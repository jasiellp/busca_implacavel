package com.br.search.product.tabela;

import java.io.Serializable;

public class CotacaoVeiculo implements Serializable, Comparable<CotacaoVeiculo>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 28996431780247672L;

	private String modelo;
	private	String tipo_veiculo; 	
	private String marca;
	private String combustivel;
	private String preco;
	private String ano_modelo;
	
	public CotacaoVeiculo(String modelo, String tipo_veiculo ,String marca ,String combustivel , String preco , String ano_modelo)
	{
		this.modelo 	  = modelo;
		this.tipo_veiculo = tipo_veiculo;
		this.marca		  = marca;
		this.combustivel  = combustivel;
		this.preco		  = preco;
		this.ano_modelo	  = ano_modelo;
		
	}

	public String getModelo()
	{
		return modelo;
	}

	public void setModelo(String modelo)
	{
		this.modelo = modelo;
	}
  
	// Eclipse Generated hashCode and equals
	@Override
	public int hashCode()
	{
		final int prime = 61;
		
		int result = 1;
		
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((tipo_veiculo == null) ? 0 : tipo_veiculo.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((combustivel == null) ? 0 : combustivel.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
		result = prime * result + ((ano_modelo == null) ? 0 : ano_modelo.hashCode());
		
		
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		CotacaoVeiculo other = (CotacaoVeiculo) obj;
		
		if (modelo == null)
		{
			if (other.modelo != null)
				return false;
		} 
		else if (!modelo.equals(other.modelo))
			return false;
		if (tipo_veiculo == null)
		{
			if (other.tipo_veiculo != null)
				return false;
		}
		else if (!tipo_veiculo.equals(other.tipo_veiculo))
			return false;
		if (tipo_veiculo == null)
		{
			if (other.tipo_veiculo != null)
				return false;
		} else if (!tipo_veiculo.equals(other.tipo_veiculo))
			return false;
		
		
		return true;
	}

	@Override
	public String toString()
	{
		return modelo;
	}

	public int compareTo(CotacaoVeiculo document)
	{
		return this.getModelo().compareTo(document.getModelo());
	}


	public String getTipo_veiculo()
	{
		return tipo_veiculo;
	}

	public void setTipo_veiculo(String tipo_veiculo)
	{
		this.tipo_veiculo = tipo_veiculo;
	}

	public String getMarca()
	{
		return marca;
	}

	public void setMarca(String marca)
	{
		this.marca = marca;
	}

	public String getCombustivel()
	{
		return combustivel;
	}

	public void setCombustivel(String combustivel)
	{
		this.combustivel = combustivel;
	}

	public String getPreco()
	{
		return preco;
	}

	public void setPreco(String preco)
	{
		this.preco = preco;
	}

	public String getAno_modelo()
	{
		return ano_modelo;
	}

	public void setAno_modelo(String ano_modelo)
	{
		this.ano_modelo = ano_modelo;
	}


}