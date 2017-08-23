package br.com.web.util;


import java.math.BigDecimal;
import java.text.Normalizer;

import br.com.web.util.exception.TsboException;


/**
 * <b>Autor:</b> Paulo Sato </br></br>
 * 
 * <b>Historico de Revisao</b> </br>
 *    01/02/2016 - Paulo Sato - Primeira Versao </br></br>
 *  
 * <b>Objetivo:</b> Classe responsavel por manipular Strings.</br>
 */
public abstract  class TsboString
{
	/**
	 * Converte uma String para double, de acordo com a quantidade de decimais
	 *
	 * Ex: 13304 com 3 casas decimais = 13,304
	 *
	 * @param valorString Valor da String
	 * @param qtdDec Quantidade de casas decimais
	 * @return
	 */
	public static double strToDbl(String valorString, int qtdDec) 
	{

		try
		{
			valorString = valorString.trim();
			String decimais = valorString.substring(valorString.length() - qtdDec);
			String inteiro = valorString.substring(0, valorString.length() - qtdDec);

			return Double.parseDouble(inteiro.concat(".").concat(decimais));

		}
		catch (Exception e)
		{
			return 0; 
		}

	}



	/**
	 * Converte String para Int
	 * 
	 * @param valorString String a ser convertida
	 * @return
	 */
	public static int strToInt(String valorString)
	{

		try
		{

			return Integer.parseInt(valorString.trim());

		}
		catch (Exception e)
		{
			return 0;
		}

	}


	/**
	 * Converte String para double
	 * @param valorString String a ser convertida
	 * @return
	 */
	public static double strToDbl(String valorString)
	{

		try
		{

			return Double.parseDouble(valorString.trim().replace(",", "."));

		}
		catch (Exception e)
		{
			return 0;
		}

	}


	/**
	 * Verifica se uma string eh nula ou vazia
	 * @param valor Valor da String
	 * @return
	 */
	public static boolean isEmptyString(String valor)
	{
		return valor == null || valor.trim().equals("");
	}


	/**
	 * Adiciona espaco a direita em uma String e limita a quantidade total de caracteres
	 * 
	 * @param valor Valor Original
	 * @param qtdCaracteresTotal Quantidade de caracteres
	 * @return
	 */
	public static String addEspacoDireitaString(String valor, int qtdCaracteresTotal)
	{

		if (valor != null)
		{	
			StringBuilder valorEditado = null;

			if (valor.length() > qtdCaracteresTotal)
			{
				valorEditado = new StringBuilder(valor.substring(0, qtdCaracteresTotal));
			}
			else
			{
				valorEditado = new StringBuilder(valor);

				while (qtdCaracteresTotal > valorEditado.length())
				{
					valorEditado.append(" ");
				}

			}

			return valorEditado.toString();
		}

		return valor;
	}
	
	/**
	 * Adiciona caracter a esquerda em uma String e limita a quantidade total de caracteres
	 * 
	 * @param valor Valor Original
	 * @param qtdCaracteresTotal Quantidade de caracteres
	 * @param sCaracter Caracter a ser adicionado a esquerda
	 * @return
	 */
	public static String addEsquerdaString(String valor, int qtdCaracteresTotal, String sCaracter)
	{

		if (valor != null)
		{	
			String valorEditado = null;

			if (valor.length() > qtdCaracteresTotal)
			{
				valorEditado = valor.substring(valor.length() - qtdCaracteresTotal, valor.length());
			}
			else
			{
				valorEditado = valor;
				
				while (qtdCaracteresTotal > valorEditado.length())
				{
					valorEditado = sCaracter.concat(valorEditado.toString());
				}
			}

			return valorEditado.toString();
		}

		return valor;
	}


	/**
	 *  Remover acentos de uma string
	 * @param str String com acentos
	 * @return
	 */
	public static String removerAcentos(String str) 
	{
		return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}

	/**
	 * Adiciona caracteres na direta ou esquerda 
	 * 
	 * @param sField 
	 * @param iSize 
	 * @param sFill
	 * @param iLeft_Right  1 right / 0 left
	 * @return
	 * @throws Exception 
	 */
	public static String fill(String sField, int iSize, String sFill, int iLeft_Right) throws Exception
	{
		int iLen = 0;

		try
		{
			if (isEmptyString(sField))
			{
				sField = "";
			}

			iLen = sField.length();

			while (iSize > iLen)
			{
				if (iLeft_Right == 1)
				{
					sField = sField + sFill;
				}
				else
				{
					sField = sFill + sField;
				}

				iLen++;
			}
		}
		catch (Exception e)
		{
			TsboException.treatError(e);
		}

		return sField;
	}
	
	/**
	 * Metodo que recebe um double e formata o numero de casas decimais e
	 * retorna uma String
	 * 
	 * @param valor
	 * @param qtdDec
	 * @return
	 * @throws Exception
	 */
	public static String formatDoubleToString(double valor, int qtdDec) throws Exception
	{

		if (valor == 0)
			return "0.00";
		else
		{
			BigDecimal bNumero = new BigDecimal(valor);

			String sNumero;

			sNumero = String.valueOf(bNumero);

			if (sNumero.indexOf(".") <= 0)// [07]
				sNumero = sNumero + ".00";

			int iPosicaoPonto = 0;
			iPosicaoPonto = sNumero.indexOf(".") + (qtdDec + 1);

			sNumero = String.valueOf(new BigDecimal(Math.abs(valor)).round(new java.math.MathContext(iPosicaoPonto, java.math.RoundingMode.HALF_EVEN)).setScale(2, java.math.RoundingMode.UP));

			return sNumero;

		}
	}
	
	
	public static String encodeString(String sStringToEncode) throws Exception
	{
	    String encodedString = "";
	   	
	    try
	    {
	        sStringToEncode = isEmptyString(sStringToEncode) ? "" : sStringToEncode;
	
	        encodedString = new String(sStringToEncode.getBytes(), "UTF-8");
	    }
	    catch (Exception e)
	    {
	        TsboException.treatError(e, "Erro ao codificar texto [" + sStringToEncode + "]." + e.getMessage());
	    }
	    return encodedString;
	}
}
