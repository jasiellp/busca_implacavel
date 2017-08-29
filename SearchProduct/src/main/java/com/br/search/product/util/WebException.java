package com.br.search.product.util;
 

public class WebException extends Exception
{
 
	private String sDescricao = "Falha";
	 
 

	/**
	 * 
	 */
	private static final long serialVersionUID = 9213598275236767581L;

	public WebException(String mensagem, int codErro)
	{	
		super(mensagem);
		this.sDescricao =mensagem; 
	}
	
	 
	 
	
	public WebException(String concat, Exception e) throws Exception
	{
		WebLog.logErro(e);
	}




	public String getsDescricao() 
	{
		return sDescricao;
	} 

}