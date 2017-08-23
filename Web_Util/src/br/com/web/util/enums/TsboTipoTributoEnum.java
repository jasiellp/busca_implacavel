package br.com.web.util.enums;

/**
* <b>Autor:</b> Rafael Ruggeri Patreze </br></br>
* 
* <b>Historico de Revisao</b> </br>
*    04/07/2016 - Rafael Ruggeri Patreze - Primeira Versao </br></br>
*  
* <b>Objetivo:</b> Tipos de Resgates do Findur</br>
*/
public enum TsboTipoTributoEnum
{
	todos(1, "Todos os tributos"),
	ir(2, "IR"),
	iof(2, "IOF");
	
	
	private int id;
	private String descricao;
	
	TsboTipoTributoEnum(int id, String descricao)
	{
		this.id = id;
		this.descricao = descricao;
	}
	
	
	public static TsboTipoTributoEnum fromInt(int paramInt)
	{
		TsboTipoTributoEnum[] arrayOfBcoTipoTributoEnum = (TsboTipoTributoEnum[]) TsboTipoTributoEnum.class.getEnumConstants();

		int i = paramInt - arrayOfBcoTipoTributoEnum[0].id;
		
		if ((i < arrayOfBcoTipoTributoEnum.length) && (i >= 0) && (arrayOfBcoTipoTributoEnum[i].id == paramInt))
		{
			return arrayOfBcoTipoTributoEnum[i];
		}
		
		for (TsboTipoTributoEnum localBcoTipoTributoEnum : arrayOfBcoTipoTributoEnum)
		{
			if (localBcoTipoTributoEnum.id == paramInt)
			{
				return localBcoTipoTributoEnum;
			}
		}
		
		throw new IllegalArgumentException("No enum " + TsboTipoTributoEnum.class + " with value " + paramInt);
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
