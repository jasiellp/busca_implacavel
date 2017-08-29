package com.br.search.product.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

import javax.sql.DataSource;

import com.br.search.product.util.tabela.WebTable; 

public class WebConexao 
{
	  
		private  ResultSet resultSet  = null;
		private  DataSource ds = null; 
		
		
		
		
	public WebConexao(DataSource ds) throws Exception
	{ 
			this.ds=ds; 
	} 
	
	
	public static String obterDBName()
	{
		return "";
	}
	
	
	/**
	 * Cria conexao direta com o Banco de Dados
	 * @return
	 * @throws Exception
	 */
	private  Connection getConnection() throws Exception 
	{ 
		Locale locale = new Locale("pt", "BR", "");

		Locale.setDefault(locale); 
		
		return ds.getConnection();
	}

	
	

	public  WebTable  executeSQL(Object query) throws Exception 
	{
		
		WebTable  tRetorno = null;
		Statement  stt = null;
		Connection con = null;
		try 
		{
		 
			 
			con =  this.getConnection();	
			
			stt =  con.createStatement();	
			
			resultSet = stt.executeQuery(query.toString()); 
			
			tRetorno =	WebTable.NovaTabela(resultSet);
			
		}
		catch (Exception e) 
		{
			this.closeConexao(stt, con); 
			throw  new WebException("Erro: " .concat( e.getMessage()),e);
		}
	 	finally
		{ 
	 		this.closeConexao(stt, con);
		}  
		return tRetorno;
		
	}
	
	
	private void closeConexao(Statement  stt,Connection con) throws Exception
	{	 
		if (resultSet != null)
		{
			try 
			{
				resultSet.close();
			} 
			catch (SQLException e) 
			{
				throw  new WebException("Erro: " .concat( e.getMessage()),e);
			}
		}
			if (stt != null)
			{
				try 
				{
					stt.close();
				} 
				catch (SQLException e) 
				{
					throw  new WebException("Erro: " .concat( e.getMessage()),e);
				}	
			}
			
			if (con != null)
			{
				try
				{
					con.close();
				} 
				catch (SQLException e) 
				{
					throw  new WebException("Erro: " .concat( e.getMessage()),e);
				}
			}
	}
	
	public  void  executeInsertSQL(Object query, String squeryName) throws Exception 
	{
		
		
		WebLog.InfoInicioCalc();
		
		try
		{
			executeInsertSQL(query);
		}
		catch (Exception e)
		{
			throw  new WebException("Erro: " .concat( e.getMessage()),e);
		}
		finally
		{
			WebLog.InfoTempo("Query: ".concat(squeryName));
		}
		
	}
	public  void  executeInsertSQL(Object query) throws Exception 
	{
		
		 
		Statement stt = null;
		Connection con = null;
		try 
		{ 
			con =  this.getConnection();	
			
			stt =  con.createStatement();	
			
			stt.executeUpdate(query.toString()); 
			
			WebLog.logInfo("Insert Realizado com sucesso.");
			
		}
		catch (Exception e) 
		{
			this.closeConexao(stt, con); 
			 
			throw  new WebException("Erro: " .concat( e.getMessage()),e);
		}
	 	finally
		{ 
	 		this.closeConexao(stt, con);
			
		}  
	}
	 
	 
	
	public WebTable executeSQL(Object query, String sQueryName) throws Exception 
	{
		
	
		try 
		{
			WebLog.InfoInicioCalc();
		 
			return executeSQL(query);
		}
		catch (SQLException | WebException e) 
		{
			throw  new WebException("Erro: " .concat( e.getMessage()),e);
		}
		finally
		{
			WebLog.InfoTempo("Query: ".concat(sQueryName));
		}
	}
	     
	
	   

}