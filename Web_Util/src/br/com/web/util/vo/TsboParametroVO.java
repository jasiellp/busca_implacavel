package br.com.web.util.vo;

/**
* <b>Autor:</b> Paulo Sato </br></br>
* 
* <b>Historico de Revisao</b> </br>
*    01/02/2016 - Paulo Sato - Primeira Versao </br></br>
*  
* <b>Objetivo:</b> Entidade que representa um Parametro </br>
*/
public final class TsboParametroVO
{

	private String chave;
	private String grupo;
	private String valor;
	
	public int getValorAsInt()
	{
		return Integer.parseInt(this.valor);
	}
	
	public double getValorAsDouble()
	{
		return Double.parseDouble(this.valor);
	}
	
	public String getChave() 
	{
		return chave;
	}
	
	public void setChave(String chave) 
	{
		this.chave = chave;
	}
	
	public String getGrupo() 
	{
		return grupo;
	}
	
	public void setGrupo(String grupo) 
	{
		this.grupo = grupo;
	}
	
	public String getValor() 
	{
		return valor;
	}
	
	public void setValor(String valor) 
	{
		this.valor = valor;
	}
}
