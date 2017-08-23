package br.com.web.util.enums;

/**
* <b>Autor:</b> Jasiel P de Sant ana </br></br>
* 
* <b>Historico de Revisao</b> </br>
*    02/08/2016 - Jasiel P de Sant ana - Primeira Versao </br></br>
*  
* <b>Objetivo:</b> Enumeradores dos Tipos de Indexadores baseado na tabela user_produto_indexador</br>
*/
public enum TsboIndexadorEnum 
{
	pre(1020001, "Pre", "PRE"),
	di( 1020002, "Cdi", "POS"),
	ipca(1020014, "Ipca", "POS"),
	igpm(1020003, "Igpm", "POS");
	
	private int id;
	private String descricao;
	private String codigo;
	
	TsboIndexadorEnum(int id, String descricao, String codigo)
	{
		this.id = id;
		this.descricao = descricao;
		this.setCodigo(codigo);
	}
	
	public static TsboIndexadorEnum fromInt(int paramInt)
	{
		TsboIndexadorEnum[] arrayOfBcoAcaoCCEnum = (TsboIndexadorEnum[]) TsboIndexadorEnum.class.getEnumConstants();

		int i = paramInt - arrayOfBcoAcaoCCEnum[0].id;
		
		if ((i < arrayOfBcoAcaoCCEnum.length) && (i >= 0) && (arrayOfBcoAcaoCCEnum[i].id == paramInt))
		{
			return arrayOfBcoAcaoCCEnum[i];
		}
		
		for (TsboIndexadorEnum localBcoAcaoCCEnum : arrayOfBcoAcaoCCEnum)
		{
			if (localBcoAcaoCCEnum.id == paramInt)
			{
				return localBcoAcaoCCEnum;
			}
		}
		
		throw new IllegalArgumentException("No enum " + TsboIndexadorEnum.class + " with value " + paramInt);
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
