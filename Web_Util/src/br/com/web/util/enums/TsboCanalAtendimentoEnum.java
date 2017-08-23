package br.com.web.util.enums;

/**
* <b>Autor:</b> Paulo Sato </br></br>
* 
* <b>Historico de Revisao</b> </br>
*    15/02/2016 - Paulo Sato - Primeira Versao </br></br>
*  
* <b>Objetivo:</b> Lista de canais de atendimento (user_canal_atendimento)</br>
*/
public enum TsboCanalAtendimentoEnum
{
	Internet_banking(1, "Internet Banking"),
	Mobile(2, "Mobile"),
	Officer(3, "Officer"),
	Atendimento(4, "Atendimento"),
	Trader(5, "Trader"),
	Findur(6, "Automatico"),
	Garantia(7,"Sistema Garantia"),
	Nao_correntista(8, "Nao Correntista"),
	Atendimento_Nao_Correntista(9, "Atendimento Nao Correntista");
	
	private int id;
	private String descricao;
	
	TsboCanalAtendimentoEnum(int id, String descricao)
	{
		this.id = id;
		this.descricao = descricao;
	}
	
	
	public static TsboCanalAtendimentoEnum fromInt(int paramInt)
	{
		TsboCanalAtendimentoEnum[] arrayOfBcoCanalAtendimentoEnum = (TsboCanalAtendimentoEnum[]) TsboCanalAtendimentoEnum.class.getEnumConstants();

		int i = paramInt - arrayOfBcoCanalAtendimentoEnum[0].id;
		
		if ((i < arrayOfBcoCanalAtendimentoEnum.length) && (i >= 0) && (arrayOfBcoCanalAtendimentoEnum[i].id == paramInt))
		{
			return arrayOfBcoCanalAtendimentoEnum[i];
		}
		
		for (TsboCanalAtendimentoEnum localBcoCanalAtendimentoEnum : arrayOfBcoCanalAtendimentoEnum)
		{
			if (localBcoCanalAtendimentoEnum.id == paramInt)
			{
				return localBcoCanalAtendimentoEnum;
			}
		}
		
		throw new IllegalArgumentException("No enum " + TsboCanalAtendimentoEnum.class + " with value " + paramInt);
	}
	
	public static TsboCanalAtendimentoEnum fromString(String sParam)
	{
		TsboCanalAtendimentoEnum[] arrayOfBcoCanalAtendimentoEnum = (TsboCanalAtendimentoEnum[]) TsboCanalAtendimentoEnum.class.getEnumConstants();

		 
		for (TsboCanalAtendimentoEnum localBcoCanalAtendimentoEnum : arrayOfBcoCanalAtendimentoEnum)
		{
			if (localBcoCanalAtendimentoEnum.descricao.equals(sParam))
			{
				return localBcoCanalAtendimentoEnum;
			}
		}
		
		throw new IllegalArgumentException("No enum " + TsboCanalAtendimentoEnum.class + " with value " + sParam);
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
