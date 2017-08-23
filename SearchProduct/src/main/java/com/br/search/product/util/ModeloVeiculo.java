package com.br.search.product.util;

public class ModeloVeiculo
{
  private String nomeModelo;
  private String idModelo;
  
  public ModeloVeiculo(String idModelo, String nomeModelo)
  {
    setIdModelo(idModelo);
    setNomeModelo(nomeModelo);
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