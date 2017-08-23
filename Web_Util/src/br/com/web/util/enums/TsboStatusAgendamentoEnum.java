package br.com.web.util.enums;

public enum TsboStatusAgendamentoEnum {
	
	AGENDADO(1, "A"),
	CANCELADO(2, "C"),
	EFETIVADO(3, "E");
	

	private int id;
	private String descricao;
	
	TsboStatusAgendamentoEnum(int id, String descricao)
	{
		this.id = id;
		this.descricao = descricao;
	}
	
	
	public static TsboStatusAgendamentoEnum fromInt(int paramInt)
	{
		TsboStatusAgendamentoEnum[] arrayOfBcoStatusResgateEnum = (TsboStatusAgendamentoEnum[]) TsboStatusAgendamentoEnum.class.getEnumConstants();

		int i = paramInt - arrayOfBcoStatusResgateEnum[0].id;
		if ((i < arrayOfBcoStatusResgateEnum.length) && (i >= 0) && (arrayOfBcoStatusResgateEnum[i].id == paramInt))
		{
			return arrayOfBcoStatusResgateEnum[i];
		}
		for (TsboStatusAgendamentoEnum localBcoRetornoServicoEnum : arrayOfBcoStatusResgateEnum)
			if (localBcoRetornoServicoEnum.id == paramInt)
				return localBcoRetornoServicoEnum;
		throw new IllegalArgumentException("No enum " + TsboStatusAgendamentoEnum.class + " with value " + paramInt);
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
