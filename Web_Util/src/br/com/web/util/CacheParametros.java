package br.com.web.util;

import java.util.ArrayList;
import java.util.Date;

import br.com.web.util.tabela.TsboTable;

public class CacheParametros 
{	
	private Date data;

	private static CacheParametros tsboCacheParametros;

	private ArrayList<UserTable> aCachedUserTable;	


	public CacheParametros()
	{
		aCachedUserTable = aCachedUserTable == null ? new ArrayList<UserTable>() : this.aCachedUserTable;		
		data  = new Date();				
	}



	/*
	 * 
	 *  METODOS DE TRATAMENTO DE CACHE: NOVO CASH, RECARREGAR CASH, VIRADA DE DATA ETC.
	 * 
	 */

	public CacheParametros Novo()
	{	
		return tsboCacheParametros == null ? new CacheParametros() : tsboCacheParametros;
	}

	public void limparCache() throws Exception
	{
		br.com.web.util.WebLog.logInfo("Limpeza de variaveis Cache.");

		aCachedUserTable = new ArrayList<UserTable>();
		
	}

	@SuppressWarnings("deprecation")
	private boolean viraData()
	{
		return data.getDate() != new Date().getDate();
	}

	private void setNovoValor() throws Exception
	{
		if(viraData())
		{
			limparCache();
		}
	}
	


	/*
	 * 
	 *  LISTA DOS CLASSES OBJETOS EM CACHE
	 * 
	 */	

	public  ArrayList<UserTable> getCachedUserTable() 
	{
		return this.aCachedUserTable;
	}

	static class UserTable
	{
		private String sNomeServico = "";
		private TsboTable tUserTable = null;

		public UserTable(String sNome, TsboTable tUserTable)
		{
			this.sNomeServico = sNome;
			this.tUserTable  = tUserTable;
		}


		public void setNomeUserTable(String sNome) 
		{
			this.sNomeServico = sNome;
		}


		public void setUserTable(TsboTable tUserTable) 
		{
			this.tUserTable = tUserTable;
		}


		public String getNomeUserTable() 
		{
			return sNomeServico;
		}

		public TsboTable getUserTable() 
		{
			return tUserTable;
		}

	}


	/*
	 * 
	 *  GETTERS / SETTERS
	 * 
	 */	

	public void setUserTable(String sNome, TsboTable tUserTable) throws Exception
	{
		try
		{
			
			int index = -1;

			loop : for(int i = 0; i < aCachedUserTable.size(); i++)
			{
				if(aCachedUserTable.get(i).getNomeUserTable().trim().equalsIgnoreCase(sNome))
				{
					index = i;
					break loop;	
				}

			}

			if(index > 0)
			{
				aCachedUserTable.get(index).setNomeUserTable(sNome);
				aCachedUserTable.get(index).setUserTable(tUserTable);
			}
			else
			{	
				aCachedUserTable.add(new UserTable(sNome, tUserTable));	
			}	

		}
		catch (Exception e)
		{
			throw new Exception (e);
		}
	}







	public TsboTable getUserTable (String sNome) throws Exception
	{

		this.setNovoValor();

		UserTable table = null;

		try
		{

			loop : for(UserTable cachedUserTable: aCachedUserTable)
			{
				if(cachedUserTable.getNomeUserTable().trim().equalsIgnoreCase(sNome))
				{
					table = cachedUserTable;

					break loop;
				}
			}

		}
		catch (Exception e)
		{
			throw new Exception (e);
		}


		return table==null ? null : table.tUserTable;
	}





}