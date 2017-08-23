package com.br.search.product.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;




public class Arquivo
{
  public Arquivo() {}
  
  public static ArrayList<MarcaVeiculo> getMarcaCarros()
  {
    return getMarca("carros");
  }
  
  public static ArrayList<MarcaVeiculo> getMarcaCaminhoes()
  {
    return getMarca("caminhoes");
  }
  
  public static ArrayList<MarcaVeiculo> getMarcaMotos()
  {
    return getMarca("motos");
  }
  


  private static ArrayList<MarcaVeiculo> getMarca(String sTipoVeiculo)
  {
    ArrayList<MarcaVeiculo> listaMarcas = new ArrayList<MarcaVeiculo>();
    
    try
    {
      JSONArray jsonMarcas = readJsonArrayFromUrl("http://fipeapi.appspot.com/api/1/".concat(sTipoVeiculo).concat("/marcas.json"));
      
      int iNumMarcas = jsonMarcas.length();
      
      for (int idxMarca = 0; idxMarca < iNumMarcas; idxMarca++)
      {
        JSONObject objMarca = jsonMarcas.getJSONObject(idxMarca);
        
        String marca = objMarca.get("name").toString();
        String idMarca = objMarca.get("id").toString();
        
        listaMarcas.add(new MarcaVeiculo(idMarca, marca));
      }
      
    }
    catch (MalformedURLException mue)
    {
      mue.printStackTrace();
    }
    catch (IOException ioe)
    {
      ioe.printStackTrace();
    }
    
    return listaMarcas;
  }
  


  public static ArrayList<ModeloVeiculo> getModeloCarro(String sId)
  {
    return getModelo("carros", sId);
  }
  
  public static ArrayList<ModeloVeiculo> getModeloCaminhao(String sId)
  {
    return getModelo("caminhoes", sId);
  }
  
  public static ArrayList<ModeloVeiculo> getModeloMoto(String sId)
  {
    return getModelo("motos", sId);
  }
  
  public static ArrayList<ModeloAnoVeiculo> getModeloAnoCarro(String sId, String sTipoVeiculo)
  {
    return getDetalheModelo("carros", sId, sTipoVeiculo);
  }
  
  public static ArrayList<ModeloAnoVeiculo> getModeloAnoCaminhao(String sId, String sTipoVeiculo)
  {
    return getDetalheModelo("caminhoes", sId, sTipoVeiculo);
  }
  
  public static ArrayList<ModeloAnoVeiculo> getModeloAnoMoto(String sId, String sTipoVeiculo)
  {
    return getDetalheModelo("motos", sId, sTipoVeiculo);
  }
  


  public static String getDetalheCarro(String sId, String sTipoVeiculo, String sAnoCode)
  {
    return getDetalhes("carros", sId, sTipoVeiculo, sAnoCode);
  }
  
  public static String getDetalheCaminhao(String sId, String sTipoVeiculo, String sAnoCode)
  {
    return getDetalhes("caminhoes", sId, sTipoVeiculo, sAnoCode);
  }
  
  public static String getDetalheMoto(String sId, String sTipoVeiculo, String sAnoCode)
  {
    return getDetalhes("motos", sId, sTipoVeiculo, sAnoCode);
  }
  





  private static ArrayList<ModeloVeiculo> getModelo(String sTipoVeiculo, String sId)
  {
    ArrayList<ModeloVeiculo> listaModelos = new ArrayList<ModeloVeiculo>();
    

    try
    {
      JSONArray jsonMarcas = readJsonArrayFromUrl("http://fipeapi.appspot.com/api/1/".concat(sTipoVeiculo).concat("/veiculos").concat("/").concat(sId).concat(".json"));
      
      int iNumMarcas = jsonMarcas.length();
      
      for (int idxMarca = 0; idxMarca < iNumMarcas; idxMarca++)
      {
        JSONObject objMarca = jsonMarcas.getJSONObject(idxMarca);
        
        listaModelos.add(new ModeloVeiculo(objMarca.get("id").toString(), objMarca.get("fipe_name").toString()));
      }
      
    }
    catch (MalformedURLException mue)
    {
      mue.printStackTrace();
    }
    catch (IOException ioe)
    {
      ioe.printStackTrace();
    }
    return listaModelos;
  }
  




  private static String getDetalhes(String sTipoVeiculo, String sId, String sIdModelo, String sAnoCode)
  {
    String sPreco = null;
    


    try
    {
      JSONObject objDetalhes = readJsonFromUrl("http://fipeapi.appspot.com/api/1/".concat(sTipoVeiculo).concat("/veiculo").concat("/").concat(sId).concat("/").concat(sIdModelo).concat("/").concat(sAnoCode).concat(".json"));
      
      sPreco = objDetalhes.get("preco").toString();


    }
    catch (MalformedURLException mue)
    {

      mue.printStackTrace();
    }
    catch (IOException ioe)
    {
      ioe.printStackTrace();
    }
    

    return sPreco;
  }
  


  private static ArrayList<ModeloAnoVeiculo> getDetalheModelo(String sTipoVeiculo, String sId, String sIdModelo)
  {
    ArrayList<ModeloAnoVeiculo> listaMarcas = new ArrayList<ModeloAnoVeiculo>();
    


    try
    {
      JSONArray jsonDetalheModelo = readJsonArrayFromUrl("http://fipeapi.appspot.com/api/1/".concat(sTipoVeiculo).concat("/veiculo").concat("/").concat(sId).concat("/").concat(sIdModelo).concat(".json"));
      
      int iNumMarcas = jsonDetalheModelo.length();
      

      for (int idxMarca = 0; idxMarca < iNumMarcas; idxMarca++)
      {
        JSONObject objMarca = jsonDetalheModelo.getJSONObject(idxMarca);
        
        listaMarcas.add(new ModeloAnoVeiculo(objMarca.get("fipe_codigo").toString(), objMarca.get("name").toString()));
      }
      

    }
    catch (MalformedURLException mue)
    {
      mue.printStackTrace();
    }
    catch (IOException ioe)
    {
      ioe.printStackTrace();
    }
    

    return listaMarcas;
  }
  

  public static JSONArray readJsonArrayFromUrl(String url)
    throws IOException, JSONException
  {
    InputStream is = new URL(url).openStream();
    try
    {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONArray json = new JSONArray(jsonText);
      return json;
    }
    finally {
      is.close();
    }
  }
  
  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException
  {
    InputStream is = new URL(url).openStream();
    try
    {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONObject json = new JSONObject(jsonText);
      return json;
    }
    finally {
      is.close();
    }
  }
  
  private static String readAll(Reader rd) throws IOException
  {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1)
    {
      sb.append((char)cp);
    }
    return sb.toString();
  }
}