package br.com.web.util.enums;

/**
* <b>Autor:</b> Jos� Douglas </br></br>
* 
* <b>Historico de Revisao</b> </br>
*    29/02/2016 - Jos� Douglas - Primeira Versao </br></br>
*  
* <b>Objetivo:</b> Tipos de Condi��o de Liquidez das Opera��es</br>
*/

public enum TsboCondicaoLiquidezEnum
{
	COM_LIQUIDEZ(1, "Com Liquidez"),
	SEM_LIQUIDEZ(2, "Sem Liquidez"),
	JANELA_LIQUIDEZ(3, "Janela de Liquidez");
	
	private int id;
	private String descricao;
	
	TsboCondicaoLiquidezEnum(int id, String descricao)
	{
		this.id = id;
		this.descricao = descricao;
	}
	
	public static TsboCondicaoLiquidezEnum fromInt(int paramInt)
	{
		TsboCondicaoLiquidezEnum[] arrayOfBcoCondicaoLiquidezEnum = (TsboCondicaoLiquidezEnum[]) TsboCondicaoLiquidezEnum.class.getEnumConstants();

		int i = paramInt - arrayOfBcoCondicaoLiquidezEnum[0].id;
		
		if ((i < arrayOfBcoCondicaoLiquidezEnum.length) && (i >= 0) && (arrayOfBcoCondicaoLiquidezEnum[i].id == paramInt))
		{
			return arrayOfBcoCondicaoLiquidezEnum[i];
		}
		
		for (TsboCondicaoLiquidezEnum localBcoCondicaoLiquidezEnum : arrayOfBcoCondicaoLiquidezEnum)
		{
			if (localBcoCondicaoLiquidezEnum.id == paramInt)
			{
				return localBcoCondicaoLiquidezEnum;
			}
		}
		
		throw new IllegalArgumentException("No enum " + TsboCondicaoLiquidezEnum.class + " with value " + paramInt);
	}

	public int getValor()
	{
		return id;
	}
	
	public void setValor(int valor)
	{
		this.id = valor;
	}
	
	public String getDescricao()
	{
		return descricao;
	}
	
	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}
}




