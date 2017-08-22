package com.br.search.product.util;

public class ModeloAnoVeiculo
{
  private String nomeModelo;
  private String idModelo;
  
  public ModeloAnoVeiculo(String idModelo, String nomeModelo)
  {
    setIdModelo(idModelo);
    setNomeModelo(nomeModelo);
  }
  

  public String getNomeModelo()
  {
    return nomeModelo;
  }
  
  public String getIdModelo() {
    return idModelo;
  }
  


  public void setNomeModelo(String nomeModelo)
  {
    this.nomeModelo = nomeModelo;
  }
  
  public void setIdModelo(String idModelo) {
    this.idModelo = idModelo;
  }
}