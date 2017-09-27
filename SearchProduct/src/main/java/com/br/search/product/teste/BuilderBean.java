package com.br.search.product.teste;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class BuilderBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7446587882893101079L;
	private String dsScript;
	private int idOpcao;

	public String getDsScript()
	{
		return this.dsScript;
	}

	public void setDsScript(String dsScript)
	{
		this.dsScript = dsScript;
	}

	public int getIdOpcao()
	{
		return this.idOpcao;
	}

	public void setIdOpcao(int idOpcao)
	{
		this.idOpcao = idOpcao;
	}

	public void processar()
	{
		
		System.out.println("--------------teste-------------------------");
        this.dsScript = "function meuCodigoJS(){";
        switch( idOpcao)
        {
            case 1:
                this.dsScript += "alert('Aqui o código se comporta da menira A!');";
                break;
            case 2:
                this.dsScript += "alert('Aqui o código se comporta da menira XYZ!');";
                break;
            case 3:
                this.dsScript += "var a = 3;";
                this.dsScript += "var b = 4;";
                this.dsScript += "var c = a + b;";
                this.dsScript += "alert('O resultdo eh ' + c + ' (comportamento opcao 3)!');";
                break;
            case 4:
                this.dsScript += "var a = 2;";
                this.dsScript += "var b = 5;";
                this.dsScript += "var c = a * b;";
                this.dsScript += "alert('O resultdo eh ' + c + ' (comportamento opcao 4)!');";
                break;
            default:
                this.dsScript += "alert('Comportamento padrao!');";
                break;
        }
        this.dsScript += "}";
    }
}