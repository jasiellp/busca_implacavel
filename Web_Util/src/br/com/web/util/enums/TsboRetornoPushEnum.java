package br.com.web.util.enums;

/**
* <b>Autor:</b> Paulo Sato </br></br>
* 
* <b>Historico de Revisao</b> </br>
*    04/02/2016 - Paulo Sato - Primeira Versao </br></br>
*  
* <b>Objetivo:</b> Enumeradores de Retorno do Push</br>
*/
public enum TsboRetornoPushEnum
{
	success(1,"success"),
	time_out(2,"time_out"),
	tec_error(3,"tec_error"), 
	ws_error(4,"ws_error"), 
	soapui_fault(5,"soapui_fault") ;

	private int id;
	private String descricao;

	TsboRetornoPushEnum(int id, String descricao)
	{
		this.id = id;
		this.descricao = descricao;
	}

	public static TsboRetornoPushEnum fromInt(int paramInt)
	{
		TsboRetornoPushEnum[] arrayOfBcoStatusRetornoPushEnum = (TsboRetornoPushEnum[]) TsboRetornoPushEnum.class.getEnumConstants();

		int i = paramInt - arrayOfBcoStatusRetornoPushEnum[0].id;

		if ((i < arrayOfBcoStatusRetornoPushEnum.length) && (i >= 0) && (arrayOfBcoStatusRetornoPushEnum[i].id == paramInt))
		{
			return arrayOfBcoStatusRetornoPushEnum[i];
		}

		for (TsboRetornoPushEnum localBcoStatusRetornoPushEnum : arrayOfBcoStatusRetornoPushEnum)
		{
			if (localBcoStatusRetornoPushEnum.id == paramInt)
			{
				return localBcoStatusRetornoPushEnum;
			}
		}

		throw new IllegalArgumentException("No enum " + TsboRetornoPushEnum.class + " with value " + paramInt);
	}
	
	
	public static TsboRetornoPushEnum fromString(String paramString)
	{
		TsboRetornoPushEnum[] arrayOfBcoStatusRetornoPushEnum = (TsboRetornoPushEnum[]) TsboRetornoPushEnum.class.getEnumConstants();

		 
		for (TsboRetornoPushEnum localBcoStatusRetornoPushEnum : arrayOfBcoStatusRetornoPushEnum)
		{
			if (localBcoStatusRetornoPushEnum.descricao.equalsIgnoreCase(paramString))
			{
				return localBcoStatusRetornoPushEnum;
			}
		}

		throw new IllegalArgumentException("No enum " + TsboRetornoPushEnum.class + " with value " + paramString);
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
