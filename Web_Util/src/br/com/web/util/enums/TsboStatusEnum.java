package br.com.web.util.enums;

/**
 * 
 * <b>Autor:</b> paulo.sato </br></br>
 * 
 * <b>Historico de Revisao</b> </br>
 *    29/04/2016 - paulo.sato - Primeira Versao </br></br>
 *  
 * <b>Objetivo:</b> Enum generico de status, pode ser utilizado em mais de um projeto. 
 * 	</br> Os enums criados nao devem ser alterados.
 *	</br> <b>Tabela:</b> user_status
 
 */
public enum TsboStatusEnum
{

	Novo(1, "Novo", ""),
	Enviado(2, "Enviado", ""),
	Falha(3, "Falha", ""),
	Processando(4, "Processando", ""), // Novos stauts para o assincrono
	Sucesso(5, "Sucesso", ""), // Novos stauts para o assincrono
	Finalizado(6,"Finalizado", ""); // Novos stauts para o assincrono
	
	private int id;
	private String descricao;
	private String codigo;
	
	TsboStatusEnum(int id, String descricao, String codigo)
	{
		this.id = id;
		this.descricao = descricao;
		this.codigo = codigo;
	}
	
	
	public static TsboStatusEnum fromInt(int paramInt)
	{
		TsboStatusEnum[] arrayOfBcoStatusEnum = (TsboStatusEnum[]) TsboStatusEnum.class.getEnumConstants();

		int i = paramInt - arrayOfBcoStatusEnum[0].id;
		if ((i < arrayOfBcoStatusEnum.length) && (i >= 0) && (arrayOfBcoStatusEnum[i].id == paramInt))
		{
			return arrayOfBcoStatusEnum[i];
		}
		for (TsboStatusEnum localBcoRetornoServicoEnum : arrayOfBcoStatusEnum)
			if (localBcoRetornoServicoEnum.id == paramInt)
				return localBcoRetornoServicoEnum;
		throw new IllegalArgumentException("No enum " + TsboStatusEnum.class + " with value " + paramInt);
	}
	
	public static TsboStatusEnum fromDescricao(String sParam)
	{
		TsboStatusEnum[] arrayOfBcoStatusEnum = (TsboStatusEnum[]) TsboStatusEnum.class.getEnumConstants();

		 
		for (TsboStatusEnum localBcoStatusEnum : arrayOfBcoStatusEnum)
		{
			if (localBcoStatusEnum.descricao.equals(sParam))
			{
				return localBcoStatusEnum;
			}
		}
		
		throw new IllegalArgumentException("No enum " + TsboStatusEnum.class + " with value " + sParam);
	}
	
	
	public static TsboStatusEnum fromCodigo(String sParam)
	{
		TsboStatusEnum[] arrayOfBcoStatusEnum = (TsboStatusEnum[]) TsboStatusEnum.class.getEnumConstants();

		 
		for (TsboStatusEnum localBcoStatusEnum : arrayOfBcoStatusEnum)
		{
			if (localBcoStatusEnum.codigo.equals(sParam))
			{
				return localBcoStatusEnum;
			}
		}
		
		throw new IllegalArgumentException("No enum " + TsboStatusEnum.class + " with value " + sParam);
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


	/**
	 * @return the codigo
	 */
	public String getCodigo()
	{
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo)
	{
		this.codigo = codigo;
	}

}
