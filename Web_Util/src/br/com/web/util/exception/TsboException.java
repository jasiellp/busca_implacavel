package br.com.web.util.exception;

import br.com.web.util.enums.TsboRetornoServicoEnum;

public class TsboException
{
	/**
     * Metodo para tratar qualquer tipo de exception para o tipo {@link Exception}. </br>
     * Se a exception for do tipo Exception, apenas &eacute; repassado o erro, caso contrario cria-se</br>
     * uma nova exception do tipo Exception, com a Exception sendo passada no construtor.</br>
     * @param e Objeto de erro
     * @throws Exception
     */
    public static void treatError(Exception e) throws Exception
    {
    	if(e instanceof TsboServicoException)
    	{		
    		throw new TsboServicoException(e.getMessage(), ((TsboServicoException)e).getiCodErro());
    	}
    	if(e instanceof Exception)
    	{		
    		throw (Exception) e;
    	}
    	else
    	{		
			Exception expt = new Exception(e);
			expt.setStackTrace(e.getStackTrace());
			throw expt;
    	}
    }
    
    /**
     * Metodo para tratar qualquer tipo de exception para o tipo {@link Exception}. </br>
     * @param e Objeto de erro
     * @param iRetCode Codigo numerico do erro ({@link TsboRetornoServicoEnum})
     * @throws Exception
     */
    public static void treatError(Exception e, int iRetCode) throws Exception
    {	    		
		Exception expt = new Exception(e.getMessage().concat(" - RETORNO CODIGO: ").concat(Integer.toString(iRetCode))); 
		expt.setStackTrace(e.getStackTrace());
		throw expt;
    }
    
    /**
     * Metodo para tratar qualquer tipo de exception para o tipo {@link Exception}. </br>
     * OBS: A mensagem de erro informada no parametro sMessage sera concatenada com a descricao do erro automaticamente.
     * @param e Objeto de erro
     * @param sMessage Mensagem de erro customizada
     * @throws Exception
     */
    public static void treatError(Exception e, String sMessage) throws Exception
    {	    		
		Exception expt = new Exception(sMessage.concat(" - ").concat(e.getMessage()));
		expt.setStackTrace(e.getStackTrace());
		throw expt;
    }
    
    
    
    /**
     * Metodo para tratar qualquer tipo de exception para o tipo {@link Exception}. </br>
     * OBS: A mensagem de erro informada no parametro sMessage sera concatenada com a descricao do erro automaticamente.
     * @param e Objeto de erro
     * @param iRetCode Codigo numerico do erro ({@link TsboRetornoServicoEnum})
     * @param sMessage Mensagem de erro customizada
     * @throws Exception
     */
    public static void treatError(Exception e, int iRetCode,  String sMessage) throws Exception
    {	    		
		Exception expt = new Exception(sMessage.concat(" - RETORNO CODIGO: ").concat(Integer.toString(iRetCode)).concat(" - ").concat(e.getMessage()));
		expt.setStackTrace(e.getStackTrace());
		throw expt;
    }
    
}
