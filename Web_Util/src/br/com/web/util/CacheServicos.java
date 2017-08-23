package br.com.web.util;

import java.util.ArrayList;
import java.util.Date;

import br.com.web.util.tabela.TsboTable;

public class CacheServicos 
{	
	private Date data;

	private static CacheServicos tsboCacheServicos;

	private ArrayList<Metadata> aCachedMetadata;	
	private ArrayList<Header>   aCachedHeader;	
	private ArrayList<Request>  aCachedRequest;	
	private ArrayList<Timeout>  aCachedTimeout;	


	public CacheServicos()
	{
		aCachedMetadata 	= aCachedMetadata == null ? new ArrayList<Metadata>() : this.aCachedMetadata;
		aCachedHeader 	= aCachedHeader 	 == null ? new ArrayList<Header>() 	 : this.aCachedHeader;
		aCachedRequest 	= aCachedRequest  == null ? new ArrayList<Request>()  : this.aCachedRequest;
		aCachedTimeout 	= aCachedTimeout  == null ? new ArrayList<Timeout>()  : this.aCachedTimeout;
		
		data  = new Date();		
		
	}



	/*
	 * 
	 *  METODOS DE TRATAMENTO DE CACHE: NOVO CASH, RECARREGAR CASH, VIRADA DE DATA ETC.
	 * 
	 */

	public CacheServicos Novo()
	{	
		return tsboCacheServicos == null ? new CacheServicos() : tsboCacheServicos;
	}

	public void limparCache() throws Exception
	{
		WebLog.logInfo("Limpeza de variaveis Cache.");

		aCachedMetadata = new ArrayList<Metadata>();
		aCachedHeader   = new ArrayList<Header>();
		aCachedRequest  = new ArrayList<Request>();
		aCachedTimeout  = new ArrayList<Timeout>();
		
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

	public  ArrayList<Metadata> getCachedMetdada() 
	{
		return this.aCachedMetadata;
	}

	public  ArrayList<Header> getCachedHeader() 
	{
		return this.aCachedHeader;
	}

	public  ArrayList<Request> getCachedRequest() 
	{
		return this.aCachedRequest;
	}

	public  ArrayList<Timeout> getCachedTimeout() 
	{
		return this.aCachedTimeout;
	}


	static class Metadata
	{
		private String sNomeServico = "";
		private Object objMetadada = null;

		public Metadata(String sNomeServico, Object objMetadada)
		{
			this.sNomeServico = sNomeServico;
			this.objMetadada  = objMetadada;
		}


		public void setNomeServico(String sNomeServico) 
		{
			this.sNomeServico = sNomeServico;
		}


		public void setMetadata(Object objMetadada) 
		{
			this.objMetadada = objMetadada;
		}


		public String getNomeServico() 
		{
			return sNomeServico;
		}

		public Object getMetadata() 
		{
			return objMetadada;
		}

	}


	static class Header
	{
		private String sNomeServico = "";
		private TsboTable tHeader = null;

		public Header(String sNomeServico, TsboTable tHeader)
		{
			this.sNomeServico = sNomeServico;
			this.tHeader 	  = tHeader;
		}


		public void setNomeServico(String sNomeServico) 
		{
			this.sNomeServico = sNomeServico;
		}


		public void setHeader(TsboTable tHeader) 
		{
			this.tHeader = tHeader;
		}


		public String getNomeServico() 
		{
			return sNomeServico;
		}

		public TsboTable getHeader() 
		{
			return tHeader;
		}

	}


	static class Request
	{
		private String sNomeServico = "";
		private Object request = null;

		public Request(String sNomeServico, Object request)
		{
			this.sNomeServico = sNomeServico;
			this.request  = request;
		}


		public void setNomeServico(String sNomeServico) 
		{
			this.sNomeServico = sNomeServico;
		}


		public void setRequest(Object request) 
		{
			this.request = request;
		}


		public String getNomeServico() 
		{
			return sNomeServico;
		}

		public Object getRequest() 
		{
			return request;
		}

	}


	static class Timeout
	{
		private String sNomeServico = "";
		private int iTimeout = 0;

		public Timeout(String sNomeServico, int iTimeout)
		{
			this.sNomeServico = sNomeServico;
			this.iTimeout 	  = iTimeout;
		}


		public void setNomeServico(String sNomeServico) 
		{
			this.sNomeServico = sNomeServico;
		}


		public void setTimeout(int iTimeout) 
		{
			this.iTimeout = iTimeout;
		}


		public String getNomeServico() 
		{
			return sNomeServico;
		}

		public int getTimeout() 
		{
			return iTimeout;
		}

	}



	/*
	 * 
	 *  GETTERS / SETTERS
	 * 
	 */	

	public void setMetadata(String sNomeServico, Object metadata) throws Exception
	{
		try
		{
			
			int index = -1;

			loop : for(int i = 0; i < aCachedMetadata.size(); i++)
			{
				if(aCachedMetadata.get(i).getNomeServico().trim().equalsIgnoreCase(sNomeServico))
				{
					index = i;
					break loop;	
				}

			}

			if(index > 0)
			{
				aCachedMetadata.get(index).setNomeServico(sNomeServico);
				aCachedMetadata.get(index).setMetadata(metadata);
			}
			else
			{	
				aCachedMetadata.add(new Metadata(sNomeServico, metadata));	
			}	

		}
		catch (Exception e)
		{
			throw new Exception (e);
		}
	}


	public void setHeader(String sNomeServico, TsboTable tHeader) throws Exception
	{

		try
		{

			int index = -1;

			loop : for(int i = 0; i < aCachedHeader.size(); i++)
			{
				if(aCachedHeader.get(i).getNomeServico().trim().equalsIgnoreCase(sNomeServico))
				{
					index = i;
					break loop;	
				}

			}

			if(index > 0)
			{
				aCachedHeader.get(index).setNomeServico(sNomeServico);
				aCachedHeader.get(index).setHeader(tHeader);
			}
			else
			{	
				aCachedHeader.add(new Header(sNomeServico, tHeader));	
			}

		}
		catch (Exception e)
		{
			throw new Exception (e);
		}	
	}

	public void setRequest(String sNomeServico, Object request) throws Exception
	{

		try
		{

			int index = -1;

			loop : for(int i = 0; i < aCachedRequest.size(); i++)
			{
				if(aCachedRequest.get(i).getNomeServico().trim().equalsIgnoreCase(sNomeServico))
				{
					index = i;
					break loop;	
				}

			}

			if(index > 0)
			{
				aCachedRequest.get(index).setNomeServico(sNomeServico);
				aCachedRequest.get(index).setRequest(request);
			}
			else
			{	
				aCachedRequest.add(new Request(sNomeServico, request));	
			}	

		}
		catch (Exception e)
		{
			throw new Exception (e);
		}
	}


	public void setTimeout(String sNomeServico, int iTimeout) throws Exception
	{

		try
		{

			int index = -1;

			loop : for(int i = 0; i < aCachedTimeout.size(); i++)
			{
				if(aCachedTimeout.get(i).getNomeServico().trim().equalsIgnoreCase(sNomeServico))
				{
					index = i;
					break loop;	
				}

			}

			if(index > 0)
			{
				aCachedTimeout.get(index).setNomeServico(sNomeServico);
				aCachedTimeout.get(index).setTimeout(iTimeout);
			}
			else
			{	
				aCachedTimeout.add(new Timeout(sNomeServico, iTimeout));	
			}	

		}
		catch (Exception e)
		{
			throw new Exception (e);
		}
	}






	public Object getMetadata (String sNomeServico) throws Exception
	{

		this.setNovoValor();

		Metadata metadata = null;

		try
		{

			loop : for(Metadata cachedMetadata: aCachedMetadata)
			{
				if(cachedMetadata.getNomeServico().trim().equalsIgnoreCase(sNomeServico))
				{
					metadata = cachedMetadata;

					break loop;
				}
			}

		}
		catch (Exception e)
		{
			throw new Exception (e);
		}


		return metadata==null ? null : metadata.objMetadada;
	}


	public TsboTable getHeader (String sNomeServico) throws Exception
	{

		this.setNovoValor();

		Header header = null;

		try
		{

			loop : for(Header retornoHeader : aCachedHeader)
			{
				if(retornoHeader.getNomeServico().trim().equalsIgnoreCase(sNomeServico))
				{
					header = retornoHeader;

					break loop;
				}
			}

		}
		catch (Exception e)
		{
			throw new Exception (e);
		}




		return header == null ? null : header.tHeader;
	}

	public Object getRequest (String sNomeServico) throws Exception
	{
		this.setNovoValor();

		Request request = null;

		try
		{

			loop : for(Request cachedRequest: aCachedRequest)
			{
				if(cachedRequest.getNomeServico().trim().equalsIgnoreCase(sNomeServico))
				{
					request = cachedRequest;

					break loop;
				}
			}
		}
		catch (Exception e)
		{
			throw new Exception (e);
		}




		return request==null ? null : request.request;
	}


	public int getTimeout (String sNomeServico) throws Exception
	{
		this.setNovoValor();

		Timeout timeout = null;

		try
		{

			loop : for(Timeout retornoTimeout : aCachedTimeout)
			{
				if(retornoTimeout.getNomeServico().trim().equalsIgnoreCase(sNomeServico))
				{
					timeout = retornoTimeout;

					break loop;
				}
			}
		}
		catch (Exception e)
		{
			throw new Exception (e);
		}




		return timeout == null ? null : timeout.iTimeout;
	}



}