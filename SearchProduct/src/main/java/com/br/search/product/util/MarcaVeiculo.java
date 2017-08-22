package com.br.search.product.util;

public class MarcaVeiculo
{
	private String nomeMarca;
	private String idMarca;

	public MarcaVeiculo(String idMarca, String nomeMarca)
	{
		setIdMarca(idMarca);
		setNomeMarca(nomeMarca);
	}

	public String getNomeMarca()
	{
		return nomeMarca;
	}

	public String getIdMarca()
	{
		return idMarca;
	}

	public void setNomeMarca(String nomeMarca)
	{
		this.nomeMarca = nomeMarca;
	}

	public void setIdMarca(String idMarca)
	{
		this.idMarca = idMarca;
	}
}