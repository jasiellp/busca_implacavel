package br.com.web.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import br.com.web.util.exception.TsboException;
import br.com.web.util.tabela.TsboTable;


public class TsboXml
{

	public static <T> String objectToXML(Object object) 
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
			System.out.println(e.getCause().toString());
		}
		finally
		{
			if (sw != null)
			{
				try
				{
					sw.close();
				}
				catch (IOException e)
				{
					// nao faz nada
				}
			}
		}

		return "";

	}



	/**
	 * @author jasiel.santana
	 * @Descricao Metodo Responsavel por formatar uma String Xml
	 * 			  Com o objetivo de identar e facilitar a viasualizacao do mesmo
	 */
	public static String formatXml(String xml)
	{
		try
		{

			Transformer serializer= SAXTransformerFactory.newInstance().newTransformer();

			serializer.setOutputProperty(OutputKeys.INDENT, "yes");

			serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2"); 

			Source xmlSource = new SAXSource(new InputSource(new ByteArrayInputStream(xml.getBytes())));

			StreamResult res =  new StreamResult(new ByteArrayOutputStream());            

			serializer.transform(xmlSource, res);

			return new String(((ByteArrayOutputStream)res.getOutputStream()).toByteArray());
		}
		catch(Exception e)
		{
			return xml;
		}
	}

	/**
	 * Metodo responsavel por Identificar assinatura basica de um XML.
	 * e afirmar se o objeto e um xml ou uma string comum.
	 * @param xml
	 * @return
	 */
	public static boolean isXml(String xml){
		return xml.trim().contains("<") && xml.trim().contains("</") && xml.trim().contains(">");
	}

	/**
	 * Converte Tabela de request em String
	 * @param tRequest
	 * @return
	 * @throws OException
	 */
	public static String convertTableToXml(TsboTable tRequest) throws Exception
	{
		String sXml = null ; 
		try
		{
			if(tRequest.getNumRows() > 0)
			{

				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document doc = builder.newDocument();
				Element results = doc.createElement("Results");

				doc.appendChild(results);

				ResultSet rs = (ResultSet) tRequest;

				ResultSetMetaData rsmd = rs.getMetaData();

				int colCount = rsmd.getColumnCount();

				while (rs.next()) {
					Element row = doc.createElement("Row");
					results.appendChild(row);
					for (int i = 1; i <= colCount; i++) {
						String columnName = rsmd.getColumnName(i);
						Object value = rs.getObject(i);
						Element node = doc.createElement(columnName);
						node.appendChild(doc.createTextNode(value.toString()));
						row.appendChild(node);
					}
				}

				DOMSource domSource = new DOMSource(doc);
				TransformerFactory tf = TransformerFactory.newInstance();
				Transformer transformer = tf.newTransformer();
				transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
				transformer.setOutputProperty(OutputKeys.METHOD, "xml");
				transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");

				StringWriter sw = new StringWriter();
				StreamResult sr = new StreamResult(sw);
				transformer.transform(domSource, sr);

				rs.close();

				sXml = formatXml (sw.toString()); 
			}

		}catch (Exception e)
		{
			TsboException.treatError(e);
		}
		return sXml;
	}

	/**
	 * retorna um cabecalho Xml
	 * @return
	 */
	public static String getCabecalhoXML()
	{
		return "<?xml version=\"1.0\"?>";
	}
	

	public static String encodeStringXML(String sStringToEncode)
	{

		if(sStringToEncode==null)  
		{
			return "";
		}
		else
		{
			String encodedString = "";

			try
			{
				sStringToEncode = TsboString.isEmptyString(sStringToEncode) ? "" : sStringToEncode;

				encodedString = new String(sStringToEncode.getBytes(), "UTF-8");
			}
			catch (Exception e)
			{

			}
			return encodedString.replaceAll("[^\\p{ASCII}]", "");
		}

	}



}
