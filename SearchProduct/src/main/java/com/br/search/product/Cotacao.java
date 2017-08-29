package com.br.search.product;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "cotacao")
@SessionScoped
public class Cotacao implements Serializable
{

	private static final long serialVersionUID = 1L;

	private static CotacaoVeiculo[] orderList = new CotacaoVeiculo[]
	{ 
	         
    };

	public CotacaoVeiculo[] getOrderList()
	{ 
		return orderList; 
	}

	public void setOrderList(CotacaoVeiculo[] orderList)
	{ 
		Cotacao.orderList=orderList; 
	}

	public static class CotacaoVeiculo
	{

		private	String tipo_veiculo; 	
		private String marca;
		private String modelo;
		private String combustivel;
		private BigDecimal preco;
		private String ano_modelo;
		 
		
		 

		public CotacaoVeiculo(String tipo_veiculo, String marca, String modelo, String combustivel, BigDecimal preco, String ano_modelo)
		{
			 
			this.tipo_veiculo = tipo_veiculo;
			this.marca		  = marca;
			this.modelo		  = modelo;
			this.combustivel  = combustivel;
			this.preco		  = preco;
			this.ano_modelo	  = ano_modelo;
		 
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




		public String getModelo()
		{
			return modelo;
		}




		public void setModelo(String modelo)
		{
			this.modelo = modelo;
		}




		public String getCombustivel()
		{
			return combustivel;
		}




		public void setCombustivel(String combustivel)
		{
			this.combustivel = combustivel;
		}




		public BigDecimal getPreco()
		{
			return preco;
		}




		public void setPreco(BigDecimal preco)
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
}