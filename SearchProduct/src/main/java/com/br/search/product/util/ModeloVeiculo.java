package com.br.search.product.util;

public class ModeloVeiculo
{
	private String nomeModelo;
	private String idModelo;
	private String AnoModelo;
	
	
	public ModeloVeiculo(String idModelo, String nomeModelo, String ano)
	{
		this.setIdModelo(idModelo);
		this.setNomeModelo(nomeModelo);
		this.setAnoModelo(ano);
	}

	public String getAnoModelo()
	{
		return AnoModelo;
	}

	public void setAnoModelo(String anoModelo)
	{
		AnoModelo = anoModelo;
	}

	
	public String getNomeModelo()
	{
		return nomeModelo;
	}

	public String getIdModelo()
	{
		return idModelo;
	}

	public void setNomeModelo(String nomeModelo)
	{
		this.nomeModelo = nomeModelo;
	}

	public void setIdModelo(String idModelo)
	{
		this.idModelo = idModelo;
	}
}