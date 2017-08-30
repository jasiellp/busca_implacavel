package com.br.search.product.dao;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

import com.br.search.product.Cotacao;
import com.br.search.product.Cotacao.CotacaoVeiculo;
import com.br.search.product.util.MarcaVeiculo;
import com.br.search.product.util.ModeloAnoVeiculo;
import com.br.search.product.util.ModeloVeiculo;
import com.br.search.product.util.WebCash;
import com.br.search.product.util.WebConexao;
import com.br.search.product.util.tabela.WebTable;

public class CotacaoVeiculoDao
{
	private static WebConexao com; 
	
	
	
	  public static ArrayList<MarcaVeiculo> getMarcaCarros() throws Exception
	  {
	    return getMarca(1);
	  }
	  
	  public static ArrayList<MarcaVeiculo> getMarcaCaminhoes() throws Exception
	  {
	    return getMarca(3);
	  }
	  
	  public static ArrayList<MarcaVeiculo> getMarcaMotos() throws Exception
	  {
	    return getMarca(2);
	  }
	  

	  public static ArrayList<ModeloVeiculo> getModeloCarro(String sId)throws Exception
	  {
	    return getModelo(1, sId);
	  }
	  
	  public static ArrayList<ModeloVeiculo> getModeloCaminhao(String sId)throws Exception
	  {
	    return getModelo(3, sId);
	  }
	  
	  public static ArrayList<ModeloVeiculo> getModeloMoto(String sId)throws Exception
	  {
	    return getModelo(2, sId);
	  }
	
	  private static ArrayList<MarcaVeiculo> getMarca(int iTipoVeiculo) throws Exception
	  {
			ArrayList<MarcaVeiculo>  listaMarca = new ArrayList<MarcaVeiculo>();
			
			com =  WebCash.getConexao(); 
			
			StringBuffer sbQuery = new StringBuffer();
			
			sbQuery.append(" Select distinct ").append("  \n");
			sbQuery.append(" 		modelo.marca             as marca ,").append("  \n"); 
			sbQuery.append(" 		marca.id_marca         as id_marca ").append("  \n");
			
			sbQuery.append("      From \"tipo\"    t ,").append("  \n");
			sbQuery.append("           \"Marca\" marca,").append("  \n");
			sbQuery.append("           \"Modelo\" modelo  ").append("  \n");
			
			sbQuery.append("       Where t.id_tipo = ").append(iTipoVeiculo).append("  \n");
			sbQuery.append(" 		and marca.id_tipo = t.id_tipo ").append("  \n");
			sbQuery.append(" 		and marca.id_marca = modelo.id_marca  order by modelo.marca;");
			
			WebTable tabela = com.executeSQL(sbQuery, "Busca Marcas");
			
			int iNumLinhas = tabela.getNumLinha();
			
			for(int i =0; i < iNumLinhas; i++)
			{
				listaMarca.add(new MarcaVeiculo(String.valueOf(tabela.getInt("id_marca", i)), tabela.getString("marca", i)));	
			}
			
			return listaMarca;
		}
	  
	  private static ArrayList<ModeloVeiculo> getModelo(int iTipoVeiculo, String sId_marca) throws Exception
	  {
			ArrayList<ModeloVeiculo>  listaMarca = new ArrayList<ModeloVeiculo>();
			
			com =  WebCash.getConexao();
			
			StringBuffer sbQuery = new StringBuffer();
			
			sbQuery.append(" Select distinct ").append("  \n");
			sbQuery.append(" 		 modelo.nome        as modelo, ").append("  \n"); 
			sbQuery.append(" 		 modelo.id_modelo   as id_modelo ").append("  \n");
			
			sbQuery.append("      From  ").append("  \n");
			sbQuery.append("           \"Marca\" marca,  ").append("  \n");
			sbQuery.append("           \"Modelo\" modelo  ").append("  \n");

			sbQuery.append("       Where marca.id_tipo = ").append(iTipoVeiculo).append("  \n");
			 
			sbQuery.append(" 		and marca.id_marca = ").append(sId_marca).append("  \n");
			sbQuery.append(" 		and modelo.id_marca = marca.id_marca  order by modelo.nome; ");
			
			WebTable tabela = com.executeSQL(sbQuery, "Busca Modelos :".concat(sId_marca));
			
			int iNumLinhas = tabela.getNumLinha();
			
			for(int i = 0; i < iNumLinhas; i++)
			{
				listaMarca.add(new ModeloVeiculo(tabela.getString("id_modelo", i), tabela.getString("modelo", i),""));	
			}
			
			return listaMarca;
		}
	  
	  public static ArrayList<ModeloAnoVeiculo> getModeloAno(  String sId_marca , String id_modelo) throws Exception
	  {
			ArrayList<ModeloAnoVeiculo>  listaMarca = new ArrayList<ModeloAnoVeiculo>();
			
			com =  WebCash.getConexao();
			
			StringBuffer sbQuery = new StringBuffer();
			
			sbQuery.append(" Select  distinct modelo.ano          as ano,").append("  \n");
			sbQuery.append(" 		 'xxx'  		     as fipe_codigo  ").append("  \n"); 
			//sbQuery.append(" 		 modelo.id_modelo    as id_modelo ").append("  \n");
			
			sbQuery.append("      From  ").append("  \n");
			 
			sbQuery.append("           \"Modelo\" modelo  ").append("  \n");

			sbQuery.append("       Where   ").append("  \n");
			 
			sbQuery.append(" 		  modelo.id_marca = ").append(sId_marca).append("  \n");
			sbQuery.append(" 		  and  modelo.id_modelo = '").append(id_modelo).append("';  \n"); 
			
			WebTable tabela = com.executeSQL(sbQuery, "Busca Modelos Ano:".concat(sId_marca));
			
			int iNumLinhas = tabela.getNumLinha();
			
			for(int i = 0; i < iNumLinhas; i++)
			{
				listaMarca.add(new ModeloAnoVeiculo(tabela.getString("fipe_codigo",i) , String.valueOf(tabela.getInt("ano", i)) ));
			}
			
			return listaMarca;
		}
	
	  public static void getDetalhes(Cotacao cotacao,int iTipo, String sMarca, String sModelo, String sAnode ,String sAnoAte,String sValorDe,String sValorAte) throws Exception
	  {
		  
		 StringBuffer sbQuery = new StringBuffer();
		  
		sbQuery.append(" Select ").append("  \n");
		sbQuery.append("   t.nome             as tipo_veiculo,").append("  \n");
		sbQuery.append("   modelo.marca       as marca,").append("  \n");
		sbQuery.append("   modelo.nome        as modelo,").append("  \n");
		sbQuery.append("   modelo.combustivel as combustivel,").append("  \n");
		sbQuery.append("   modelo.preco       as preco,").append("  \n");
		sbQuery.append("   modelo.ano         as ano_modelo").append("  \n");

		sbQuery.append("  From \"tipo\"    t ,").append("  \n");
		sbQuery.append("       \"Modelo\" modelo,").append("  \n");
		sbQuery.append("       \"Marca\" marca").append("  \n");

		sbQuery.append(" Where t.id_tipo =  ").append(iTipo).append("  \n");
		sbQuery.append(" and marca.id_tipo = t.id_tipo ").append("  \n");
		sbQuery.append(" and marca.id_marca = modelo.id_marca").append("  \n");
		sbQuery.append("  --and modelo.ano IN ('2000','2001','2002') ").append("  \n");
		
		if(!sMarca.trim().equals(""))
		{
			sbQuery.append(" and modelo.marca= '").append(sMarca).append("' \n");
		}
		
		if(!sModelo.trim().equals(""))
		{
			sbQuery.append(" and modelo.nome = '").append(sModelo).append("' \n");
		}
		
		
		if(!sAnode.trim().equals(""))
		{
			sbQuery.append(" and modelo.ano >= '").append(sAnode).append("' \n");
		}
		
		if(!sAnoAte.trim().equals(""))
		{
			sbQuery.append(" and modelo.ano <= '").append(sAnoAte).append("' \n");
		}
		
		/*if(!sValorDe.trim().equals(""))
		{
			sbQuery.append(" and modelo.preco >= '").append(sValorDe).append("' \n");
		}
		
		if(!sValorAte.trim().equals(""))
		{
			sbQuery.append(" and modelo.preco  <= '").append(sValorAte).append("' \n");
		}*/

		sbQuery.append("  order by  modelo.nome,modelo.ano;").append("  \n");
		
		WebTable tabela = com.executeSQL(sbQuery, "Busca Detalhes ");
		
		int iNumLinhas = tabela.getNumLinha();
		
		CotacaoVeiculo[] m_cotacao = new CotacaoVeiculo[iNumLinhas];
		
		
		DecimalFormat formatoDois = new DecimalFormat("##,###,###,##0.00", new DecimalFormatSymbols (new Locale ("pt", "BR")));
		formatoDois.setMinimumFractionDigits(2); 
		formatoDois.setParseBigDecimal (true);
		for(int i = 0; i < iNumLinhas; i++)
		{
			m_cotacao[i]= new CotacaoVeiculo(tabela.getString("tipo_veiculo", i),tabela.getString("marca", i),tabela.getString("modelo", i),tabela.getString("combustivel", i), formatoDois.format(tabela.getDouble("preco", i))  ,tabela.getString("ano_modelo", i));
		}
		
		cotacao.setOrderList(m_cotacao);
		  
	  } 

}
