package br.com.web.util;

import java.math.BigDecimal;
import java.util.Locale;

import br.com.web.util.exception.TsboException;

public class TsboMath
{
	

	public static BigDecimal casasDecimais(int casas, double valor)
	{
	    String quantCasas = "%."+casas+"f", textoValor = "0";
	    try
	    {
	        textoValor = String.format(Locale.getDefault(), quantCasas, valor);
	    }
	    catch(java.lang.IllegalArgumentException e)
	    {
	        // Quando os digitos com 2 casas decimais forem Zeros, exemplo: 0.000001233888.
	        // Nao existe valor 0,00 , logo entra na java.lang.IllegalArgumentException.
	        if(e.getMessage().equals("Digits < 0"))
	            textoValor = "0";
	      
	    }
	    return new BigDecimal(textoValor.replace(",", "."));
	}
	
	
	public static double arredondarDecimal(double dValor, int iPrecisao) throws Exception
	{
		try
		{
			//int temp = (int)(dValor * Math.pow(10 , iPrecisao));  
			//return ((double)temp)/Math.pow(10 , iPrecisao); 
			
			BigDecimal bd = new BigDecimal(dValor);
			bd = bd.setScale(iPrecisao, BigDecimal.ROUND_HALF_UP);
			return bd.doubleValue();
		}
		catch (Exception e)
		{
			TsboException.treatError(e);
		}		
		return 0d;
	}

	public static double corrigirDizima(double dValor) throws Exception
	{
		try
		{
			return truncarDecimal(arredondarDecimal(dValor,3),2);
		}
		catch (Exception e)
		{
			TsboException.treatError(e);
		}
		return 0d; 
	}

	public static double corrigirDizima(String sValor) throws Exception
	{
		try
		{
			return corrigirDizima(Double.parseDouble(sValor));
		}
		catch (Exception e)
		{
			TsboException.treatError(e);
		}
		return 0d; 
	}	

	public static String removeNotacaoCientifica(double dValor)
	{
		return new BigDecimal(dValor).toPlainString();
	}
	
	public static double truncarDecimal(double dValor, int iPrecisao) throws Exception
	{
		try
		{
			BigDecimal bdValor = new BigDecimal (String.valueOf(dValor)).setScale(iPrecisao, BigDecimal.ROUND_DOWN);
			return bdValor.doubleValue();
		}
		catch (Exception e)
		{
			TsboException.treatError(e);
		}		
		return 0d;
	}
}
