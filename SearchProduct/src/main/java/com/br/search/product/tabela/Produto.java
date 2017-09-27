package com.br.search.product.tabela;

import java.io.Serializable;

public class Produto implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6159429347579531481L;
	
	public String id;
	public String tipo;
	public String nome; 
	public String taxa;
	
	public int prazo;
	public String data_inicio;
	public String data_fim;
	public int quantidade_parcelas;
	

	public String Valor_parcela;
	public String Valor_entrada;
	

	
	
	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getTipo()
	{
		return tipo;
	}

	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getTaxa()
	{
		return taxa;
	}

	public void setTaxa(String taxa)
	{
		this.taxa = taxa;
	}

	public int getPrazo()
	{
		return prazo;
	}

	public void setPrazo(int prazo)
	{
		this.prazo = prazo;
	}

	public String getData_inicio()
	{
		return data_inicio;
	}

	public void setData_inicio(String data_inicio)
	{
		this.data_inicio = data_inicio;
	}

	public String getData_fim()
	{
		return data_fim;
	}

	public void setData_fim(String data_fim)
	{
		this.data_fim = data_fim;
	}

	public int getQuantidade_parcelas()
	{
		return quantidade_parcelas;
	}

	public void setQuantidade_parcelas(int quantidade_parcelas)
	{
		this.quantidade_parcelas = quantidade_parcelas;
	}

	public String getValor_parcela()
	{
		return Valor_parcela;
	}

	public void setValor_parcela(String valor_parcela)
	{
		Valor_parcela = valor_parcela;
	}

	public String getValor_entrada()
	{
		return Valor_entrada;
	}

	public void setValor_entrada(String valor_entrada)
	{
		Valor_entrada = valor_entrada;
	}
	

	public Produto()
	{
	}

	public Produto(String id,String tipo, String nome,  String taxa, int prazo, String data_inicio, String data_fim, int quantidade_parcelas, String Valor_parcela, String Valor_entrada)
	{
		
		this.quantidade_parcelas=quantidade_parcelas; 
		this.Valor_parcela=Valor_parcela;
		this.Valor_entrada=Valor_entrada;
		this.id = id;
		this.tipo  = tipo;
		this.nome  = nome; 
		this.taxa  = taxa;
		this.prazo = prazo;
		this.data_inicio = data_inicio;
		this.data_fim=data_fim;
	}

 
 

	@Override
	public int hashCode()
	{
		int hash = 7;
		hash = 59 * hash + (this.tipo != null ? this.tipo.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final Produto other = (Produto) obj;
		
		if ((this.tipo == null) ? (other.tipo != null) : !this.tipo.equals(other.tipo))
		{
			return false;
		}
		return true;
	}
}