package br.com.web.util;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
* <b>Autor:</b> Jasiel </br></br>
* 
* <b>Historico de Revisao</b> </br>
*    11/02/2016 - Jasiel - Primeira Versao </br></br>
*  
* <b>Objetivo:</b> Classe responsavel por gerar o numero de sessao unico utilizado para restrear a transacao.</br>
*/
public class TsboNSU
{
	
	public static String gerarNSU(){  
		return "NSU_".concat(new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date()));
	}
}
