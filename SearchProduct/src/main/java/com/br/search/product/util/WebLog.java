package com.br.search.product.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.Priority;
import org.apache.log4j.RollingFileAppender;
import org.xml.sax.InputSource;
 
 

public class WebLog
{

	/*private static Logger log = Logger.getLogger(TsboLog.class);*/
	private static Logger log = null;

	private final static String EXTENSAO = ".java";
	private final static String LAYOUT_00 = "%m%n";
	
	private static String LAYOUT_01 = "%-2d{ HH:mm:ss.SSS}  %5p  - %m%n";
	private final static String SEPARADOR = "---------------------------------------------------------------------------";
	private final static String VAZIO = "";
	private static String LOG_DIR= null;
	private static long tempoInicio;
	private static long tempo;
	private static int  numSessao;

	protected static String nome;
	protected static String classe;
	protected static String metodo;
	protected static String sessao = "";
	protected static String nsu = "";
	protected static Logger rootLogger = Logger.getRootLogger();

	
	protected WebLog(String nome, String nsu) throws Exception
	{ 
		WebLog.nsu  = nsu;

		WebLog.nome = nome;
 
		
		if(log == null)
		{
			log = Logger.getLogger(nome);
			LOG_DIR = System.getenv("LOG_DIR");
		}

		
		
		tempoInicio = System.currentTimeMillis();

		relatorio_abertura();

		cabecalho();

		propriedades(rootLogger, LAYOUT_01);

	}

	public static WebLog NovoLog(String nome, String nsu) throws Exception
	{
		return new WebLog(nome, nsu);
	}

	@SuppressWarnings("deprecation")
	private static void cabecalho() throws Exception
	{
		rootLogger.removeAllAppenders();
		propriedades(rootLogger, LAYOUT_00);

		log(VAZIO, Priority.INFO, VAZIO);
		log(VAZIO, Priority.INFO, SEPARADOR);
		log(VAZIO, Priority.INFO, "Processo: ".concat(nome));
		 

		if (!nsu.isEmpty())
			log(VAZIO, Priority.INFO, "Nsu  : ".concat(nsu));

		rootLogger.removeAllAppenders();
	}

	protected static String data()
	{
		return new SimpleDateFormat("ddMMyyyy").format(new Date());
	}

	@SuppressWarnings("deprecation")
	public static String getSessao()
	{
		numSessao++;
		
		if(numSessao == 3)
		{
			numSessao = 0;
			try 
			{
				sessao = Sessao.retrieveSessionId();
			} 
			catch (Exception e) 
			{
			}
		}
		try 
		{
			log(VAZIO, Priority.INFO, "Sessao  : ".concat(sessao));
			log(VAZIO, Priority.INFO, "Num Sessao  : ".concat(String.valueOf(numSessao)));
			log(VAZIO, Priority.INFO, VAZIO);
		}
		catch (Exception e) 
		{
		
		}
		
		return sessao;
	}

	@SuppressWarnings("deprecation")
	public static void setSessao(String sSessao) throws Exception
	{
		log(VAZIO, Priority.INFO, "Sessao  : ".concat(sSessao));
		log(VAZIO, Priority.INFO, VAZIO);
		sessao = sSessao;
	}

	
	
	@SuppressWarnings("deprecation")
	public static void setNsu(String sNSU) throws Exception
	{
		log(VAZIO, Priority.INFO, "sNSU  : ".concat(sNSU));
		log(VAZIO, Priority.INFO, VAZIO);
		WebLog.nsu = sNSU;
	}

	
	
	
	public static String getNSU()
	{
		return nsu;
	}

	public static String classeChamadora(boolean metodo)
	{

		Throwable thr = new Throwable();

		thr.fillInStackTrace();

		String nome_classe;

		WebLog.classe = thr.getStackTrace()[2].getFileName().toString().replace(EXTENSAO, VAZIO);
		WebLog.metodo = thr.getStackTrace()[2].getMethodName();

		if (metodo)
			nome_classe = "Classe: ".concat(WebLog.classe.concat(" - Metodo: ").concat(WebLog.metodo));
		else
			nome_classe = "Classe: ".concat(WebLog.classe);

		return nome_classe.contains(EXTENSAO) ? nome_classe.replace(EXTENSAO, VAZIO).concat(" - ") : nome_classe.concat(" - ");
	}

	/**
	 * Metodo responsavel por substituir o arquivo de propriedades padrao do
	 * Log4j, facilitando assim a customizacao da classe de log.
	 * 
	 * @param rootLogger
	 * @param sLayout
	 * @author jasiel.santana
	 * @throws Exception
	 * 
	 */
	protected static void propriedades(Logger rootLogger, String sLayout) throws Exception
	{

		rootLogger.setLevel(Level.DEBUG);

		PatternLayout layout = new PatternLayout(sLayout);

		/** Adiciona o layout de cada linha do Log. */
		rootLogger.addAppender(new ConsoleAppender(layout));
		
		try
		{
			/** Define Local para Salvar o arquivo de log */
			RollingFileAppender fileAppender = new RollingFileAppender(layout, LOG_DIR.concat("\\".concat(nome).concat("_").concat(data()).concat(".log")));

			// Adiciona as definicoes ao log
			rootLogger.addAppender(fileAppender);

		}
		catch (Exception e)
		{
			//System.out.println("Erro " + e.getMessage());
		}
	}

	 

	/**
	 * 
	 * @author jasiel.santana
	 * @param objeto
	 * @param legenda
	 * @throws Exception
	 * 
	 * @PreRequisito Quando passar um objeto para essa classe Certifique-se que
	 *               a Classe possui a seguinte anotacao @XmlRootElement
	 *               conforme exemplo abaixo:
	 * 
	 *               <code>
	 * 
	 @XmlRootElement public class Response {
	 * 
	 *                 public Response() {
	 * 
	 *                 }
	 * 
	 *                 String Nome; public String getNome() { return Nome;
	 *                 </code>
	 */

	@SuppressWarnings("deprecation")
	public static void logXml(Object objeto, String legenda) throws Exception
	{
		if(objeto != null)
		{
			log(VAZIO, Priority.INFO, legenda);
			log(VAZIO, Priority.INFO, objectToXML(objeto));	
		}
	}

	@SuppressWarnings("deprecation")
	public static void logQuery(Object objeto, String legenda) throws Exception
	{

		log(VAZIO, Priority.INFO, legenda);
		log(VAZIO, Priority.INFO, objeto.toString());

	}

	@SuppressWarnings("deprecation")
	public static void logInfo(String message) throws Exception
	{
		classeChamadora(true);
		log(classeChamadora(false), Priority.INFO, message);
	}

	public static void InfoInicioCalc()
	{
		tempo = System.currentTimeMillis();
	}

	@SuppressWarnings(
	{ "deprecation", "resource" })
	public static void InfoTempo(String metodo) throws Exception
	{
		//log("Tempo de Execucao", Priority.DEBUG, new Formatter().format("\nO Metodo %s foi executado em %.3f ms%n", metodo, (System.currentTimeMillis() - tempo) / 1000d).toString());
		log("Tempo de Execucao", Priority.INFO, new Formatter().format("\nO Metodo %s foi executado em %.3f ms%n", metodo, (System.currentTimeMillis() - tempo) / 1000d).toString());
	}

	@SuppressWarnings("deprecation")
	public static void logDebug(String message) throws Exception
	{
		log(classeChamadora(true), Priority.DEBUG, message);
	}

	@SuppressWarnings("deprecation")
	public static void logFatal(String message) throws Exception
	{
		log(classeChamadora(true), Priority.FATAL, message);
	}

	@SuppressWarnings("deprecation")
	public static void logErro(String message) throws Exception
	{
		log(classeChamadora(true), Priority.ERROR, message);
	}

	@SuppressWarnings("deprecation")
	public static void logErro(Exception erro) throws Exception
	{

		int tamanho = erro.getStackTrace().length;
		int indexLog = 0;

		// Localiza o Script Findur Customizado que gerou o erro
		loop_ : for (int i = 0; i < tamanho; i++)
		{
			if (erro.getStackTrace()[i].getClassName().toString().toLowerCase().contains("br.com.original"))
			{
				// pular caso o erro esteja no BCException
				if (!erro.getStackTrace()[i].getClassName().toString().toLowerCase().contains("br.com.original.bcoutil.bcException"))
				{
					indexLog = i;
					break loop_;
				}
			}
		}

		log(VAZIO, Priority.ERROR, "Classe: ".concat(erro.getStackTrace()[indexLog].getClassName().toString()));
		log(VAZIO, Priority.ERROR, "Metodo: ".concat(erro.getStackTrace()[indexLog].getMethodName().toString()));
		log(VAZIO, Priority.ERROR, "Linha: ".concat(String.valueOf(erro.getStackTrace()[indexLog].getLineNumber())));
		log(VAZIO, Priority.ERROR, "Descricao: ".concat(erro.getMessage()));

	}

	@SuppressWarnings("deprecation")
	public static void logWarn(String message) throws Exception
	{
		log(classeChamadora(true), Priority.WARN, message);
	}

	@SuppressWarnings(
	{ "resource", "deprecation" })
	public static void finalProcessoSucesso() throws Exception
	{
		rootLogger.removeAllAppenders();

		propriedades(rootLogger, LAYOUT_00);

		log(VAZIO, Priority.INFO, VAZIO);
		log(VAZIO, Priority.INFO, "Processo: ".concat(nome).concat(" Finalizado com sucesso."));
		log(VAZIO, Priority.INFO, new Formatter().format("\nTempo Execucao %.3f ms%n", (System.currentTimeMillis() - tempoInicio) / 1000d).toString());
		log.removeAllAppenders();
	//	log.shutdown();
	}

	@SuppressWarnings(
	{ "resource", "deprecation" })
	public static void finalProcessoErro() throws Exception
	{
		rootLogger.removeAllAppenders();

		propriedades(rootLogger, LAYOUT_00);

		log(VAZIO, Priority.ERROR, VAZIO);
		log(VAZIO, Priority.ERROR, "Processo: ".concat(nome).concat(" Finalizado com Falha."));
		String mensagem = new Formatter().format("\nTempo Execucao %.3f ms%n", (System.currentTimeMillis() - tempoInicio) / 1000d).toString();
		log(VAZIO, Priority.ERROR, mensagem);
		log.removeAllAppenders();
		//log.shutdown();

		 
	}

	protected static void log(String classe, Priority priority, String menssage) throws Exception
	{

		//System.out.println("\n".concat(priority.toString().concat(" ").concat(classe.concat(menssage))));
  
		 
			log.log(priority, nsu.concat("  ").concat(classe.concat(menssage)));
 

	}

	 
	private void relatorio_abertura() throws Exception
	{
 
	}

 
 
	private static <T> String objectToXML(Object object) throws IOException
	{

		StringWriter sw = new StringWriter();
		try
		{

			JAXBContext pContext = JAXBContext.newInstance(object.getClass());

			Marshaller marshaller = pContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.marshal(object, sw);

			return formatXml(sw.toString());
		}
		catch (JAXBException e)
		{
			//System.out.println(e.getCause().toString());
		}
		finally
		{
			closeQuietly(sw);
		}
		return "";

	}

	private static void closeQuietly(Closeable c) throws IOException
	{ 
			if (c != null)
			{
				c.close();
			} 
	}

	/**
	 * @author jasiel.santana
	 * @Descricao Metodo Responsavel por formatar uma String Xml Com o objetivo
	 *            de identar e facilitar a viasualizacao do mesmo no momento do
	 *            log.
	 */
	public static String formatXml(String xml)
	{
		try
		{
			Transformer serializer = SAXTransformerFactory.newInstance().newTransformer();
			serializer.setOutputProperty(OutputKeys.INDENT, "yes");

			serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			Source xmlSource = new SAXSource(new InputSource(new ByteArrayInputStream(xml.getBytes())));
			StreamResult res = new StreamResult(new ByteArrayOutputStream());
			serializer.transform(xmlSource, res);
			return new String(((ByteArrayOutputStream) res.getOutputStream()).toByteArray());
		}
		catch (Exception e)
		{

			return xml;
		}
	} 
}
