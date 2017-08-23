package br.com.web.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Sessao
{
 
	
	public static String retrieveSessionId()
	{
		return "".concat(new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date()));
	}
}
