package br.com.web.util.exception;

import br.com.web.util.enums.TsboRetornoServicoEnum;

public class TsboServicoException extends Exception
{

	private int iCodErro = TsboRetornoServicoEnum.problemas_tecnico.getValor();
	private String sDescricao = "Falha";
	private TsboRetornoServicoEnum retornoServico;
 

	/**
	 * 
	 */
	private static final long serialVersionUID = 9213598275236767581L;

	public TsboServicoException(String mensagem, int codErro)
	{	
		super(mensagem);
		this.sDescricao =mensagem;
		this.iCodErro=codErro;
	}
	
	public TsboServicoException(TsboRetornoServicoEnum retorno)
	{	
		super(retorno.getDescricao());
		this.sDescricao =retorno.getDescricao();
		this.iCodErro=retorno.getValor();
		this.retornoServico=retorno;
	}
	
	
	public TsboRetornoServicoEnum getRetornoServico() 
	{
		return retornoServico;
	}
	
	public String getsDescricao() 
	{
		return sDescricao;
	}

	public int getiCodErro() 
	{
		return iCodErro;
	}

}
