package br.com.web.util.tabela;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 



/**
 * Classe Responsavel por EMULAR-Objetos TsboTable do Findur
 * @author jasiel.santana
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class TsboTable 
{

	
	public static TsboTable NovaTabela(ResultSet resultSet) throws SQLException
	{
		return new TsboTable(resultSet);
	}
	
	
	public static TsboTable NovaTabela() throws SQLException
	{
		return new TsboTable();
	}
	
	@XmlElement(required = true)
	private ArrayList<Object[]> value;
	
	@XmlElement(required = true)
	private Object[][] valor;
	
	@XmlElement(required = true)
	private Object[][] valor_info;
	
	private Object[][] getValor_info()
	{
		return valor_info;
	}
	
	private Object[][] getValor()
	{
		return valor;
	}



	private int iNumColuna;
	private int iNumLinha;
	
	public int getNumColuna() 
	{
		return iNumColuna;
	}
 
	public int getNumLinha() 
	{
		return iNumLinha;
	}


	private boolean InfoCompare(TsboTable tabela)
	{ 
		return Arrays.equals(tabela.getValor_info()[0], valor_info[0]) && Arrays.equals(tabela.getValor_info()[1],valor_info[1]);
	}

	private ResultSetMetaData metadata;
	
	public void add_coluna(String nome_coluna, int tipo)
	{
		Object[][] valor_info_ = new Object[2][iNumColuna+1];
		Object[][] valor_	   = new Object[iNumLinha][iNumColuna+1];
		  
		  
		for (int i=0; i<iNumColuna; i++) 
		{
			valor_info_[0][i]=valor_info[0][i];
		    valor_info_[1][i]=valor_info[1][i];
				   
		} 
		  
		 // captura o Nome da coluna
		  valor_info_[0][iNumColuna]= nome_coluna.toUpperCase();
		  // captura o Tipo da coluna
		  valor_info_[1][iNumColuna]= tipo;
	
		  for (int i=0; i<iNumColuna; i++) 
		  {
				for(int j = 0; j < iNumLinha;j++ )
				{
					valor_[j][i]=valor[j][i];
				} 
		  }
		  
		  iNumColuna++;
		  
		  this.valor_info =valor_info_;
		  
		  this.valor =valor_;
	}
	
	
	private TsboTable() 
	{
		iNumColuna = 0;
		iNumLinha=0;
		
	}
	
	
	
	private TsboTable (ResultSet resultSet) throws SQLException
	{	
		
		
		value = new ArrayList<Object[]>();
		
		metadata    = resultSet.getMetaData();
		
		iNumColuna  = metadata.getColumnCount();
 
		valor_info  = new Object[2][iNumColuna];
		
		
		for(int i = 1; i <= iNumColuna; i++ )
		{
			// captura o Nome da coluna
			valor_info[0][i-1]= metadata.getColumnName(i);
			// captura o Tipo da coluna
			valor_info[1][i-1]= metadata.getColumnType(i);
		} 
		
	 		
		int iType    = 0;
		
		boolean bLinha = false;
		
		while(resultSet.next())
        { 
			Object[] valor__	= new Object[iNumColuna];
			
            for(int j=1;j<iNumColuna+1;j++)
            {	
            	iType = (int)valor_info[1][j-1];
            	
            	if(java.sql.Types.INTEGER == iType  )
            	{	 	
            		valor__[j-1] = resultSet.getInt(j);
            	}
            	if(java.sql.Types.DOUBLE == iType || java.sql.Types.DECIMAL == iType || java.sql.Types.FLOAT == iType|| java.sql.Types.NUMERIC == iType)
            	{
            		valor__[j-1] = resultSet.getDouble(j);
            	}
            	if(java.sql.Types.VARCHAR == iType || java.sql.Types.CHAR == iType)
            	{
            		valor__[j-1] = resultSet.getString(j);
            	} 
            	if(java.sql.Types.DATE == iType || java.sql.Types.TIMESTAMP == iType)
            	{
            		valor__[j-1] = resultSet.getDate(j);
            	} 
            	if(java.sql.Types.CLOB == iType )
            	{
            		valor__[j-1] = TsboTable.NovaTabela(null);
            	} 
            	 
            }
            
            value.add(valor__);
            bLinha=true; 
        }  
		
		
		iNumLinha = value.size();	
		
		valor 		= new Object[iNumLinha][iNumColuna];
		
		for (int i = 0; i <= iNumLinha; i++)
		{
			if(i==iNumLinha)
			{
				break;
			}
			else
			{
				valor[i]=value.get(i);	
			} 
		}
		
		if(!bLinha)
		{
			iNumLinha=-1;	
		}
		
		value.clear();
		
	}
	
	public void concatenarTabela(TsboTable novaTabela)
	{
		if(novaTabela.getNumLinha() >=1 )
		{
			if(InfoCompare(novaTabela))
			{
				 Object[] obj_return = concat(valor , novaTabela.getValor());
				 int iLinhas = obj_return.length;
				
				 valor  = new Object[iLinhas][novaTabela.getValor()[0].length];
				 
				  for(int i = 0; i < iLinhas; i++)
				  {
					  valor[i]= (Object[]) obj_return[i];
				  } 
				   
				  this.iNumLinha=iLinhas;
			}	
		}
	}
	
	
	public void add_linha()
	{
		this.add_linha(1);
	}
	
	
	public void add_linha(int numLinha)
	{ 
		 Object[] obj_return = concat(valor , new Object[numLinha][iNumColuna]);
		
		 int iLinhas = obj_return.length;
			
		 valor  = new Object[iLinhas][iNumColuna];
		 
		  for(int i = 0; i < iLinhas; i++)
		  {
			  valor[i]= (Object[]) obj_return[i];
		  } 
		   
		  this.iNumLinha=iLinhas;
		
	}
	
	
	private Object[] concat(Object[][] a, Object[][] b) 
	{
		   int aLen = a.length;
		   int bLen = b.length;
		   Object[] c = new Object[aLen+bLen];
		   System.arraycopy(a, 0, c, 0, aLen);
		   System.arraycopy(b, 0, c, aLen, bLen);
		   
		   return c;
	}
	
	
	public int getColType(int idColuna)
	{
		return (int) this.valor_info[1][idColuna];
	}
	
	
	public int getColType(String ColunaNome)
	{
		int iNumLinha = valor_info[0].length;
		
		int id = -1;
		
		for(int i = 0; i < iNumLinha; i++ )
		{ 
			if(valor_info[0][i].toString().equalsIgnoreCase(ColunaNome))
			{
				id = (int)valor_info[1][i];
			}
		}
		
		return id;
	}
	 
	public String getColName(int idColuna)
	{
		return (String) this.valor_info[0][idColuna];
	}
	 
	public void viewTable()
	{
		
		 TsboViewTable frame = new TsboViewTable(valor,this.valor_info[0]);
		 
		 frame.setVisible(true);
		 
	}
	 
	
	public int getInt(int coluna,int linha)
	{ 
		
		Object objRetorno = valor[linha][coluna];
		
		if (objRetorno instanceof Double) 
		{ 
			return  ((Double) objRetorno).intValue();	
		}
		else
		{
			return objRetorno == null?0:(int) objRetorno;	
		}		
	}
	
	public int getInt(String coluna,int linha)
	{  
		Object objRetorno = valor[linha][getIdColuna(coluna)];
		
		 
		
		if (objRetorno instanceof Double) 
		{ 
			return ((Double) objRetorno).intValue();	
		}
		else
		{
			return objRetorno == null?0:(int) objRetorno;	
		}
	}
	 
	public TsboTable getTable(String coluna,int linha)
	{  
		Object objRetorno = valor[linha][getIdColuna(coluna)];
		if (objRetorno instanceof Double) 
		{ 
			return ((TsboTable) objRetorno);	
		}
		else
		{
			return objRetorno == null?null:(TsboTable) objRetorno;	
		}
	}
	 
	public TsboTable getTable(int coluna,int linha)
	{ 
		
		Object objRetorno = valor[linha][coluna];
		 
		if (objRetorno instanceof Double) 
		{ 
			return  ((TsboTable) objRetorno);	
		}
		else
		{
			return objRetorno == null?null:(TsboTable) objRetorno;	
		}		
	}
	  
	public void setTable(String coluna,int linha, TsboTable tValor)
	{
		this.valor[linha][getIdColuna(coluna)] = tValor; 
	}
	
	public void setTable(int coluna,int linha, TsboTable tValor)
	{
		this.valor[linha][coluna] = tValor; 
	}
	
	public void setInt(String coluna,int linha, int iValor)
	{
		this.valor[linha][getIdColuna(coluna)] = iValor; 
	}
	
	public void setInt(int coluna,int linha, int iValor)
	{
		this.valor[linha][coluna] = iValor; 
	}
	
	public void setDate(String coluna,int linha, Date iValor)
	{
		this.valor[linha][getIdColuna(coluna)] = iValor; 
	}
	
	public void setDate(int coluna,int linha, Date iValor)
	{
		this.valor[linha][coluna] = iValor; 
	}
	
	
	public void setString(String coluna,int linha, String sValor)
	{
		this.valor[linha][getIdColuna(coluna)] = sValor; 
	}
	
	public void setString(int coluna,int linha, String sValor)
	{
		this.valor[linha][coluna] = sValor; 
	}
	
	
	 
	public void setDouble(String coluna,int linha, double dValor)
	{
		this.valor[linha][getIdColuna(coluna)] = dValor; 
	}
	
	public void setDouble(int coluna,int linha, double dValor)
	{
		this.valor[linha][coluna] = dValor; 
	}
	
	public Double getDouble(int coluna,int linha)
	{
		Object objRetorno = valor[linha][coluna];
		return objRetorno == null?0.0:(Double) objRetorno;
	}
	
	public Double getDouble(String coluna,int linha)
	{ 
		Object objRetorno = valor[linha][getIdColuna(coluna)];
		return objRetorno == null?0.0:(Double) objRetorno;
	}
	
	public String getString(int coluna,int linha)
	{
		Object objRetorno = valor[linha][coluna];
		return objRetorno == null?"":objRetorno .toString();
	}
	
	public String getString(String coluna,int linha)
	{ 
		Object objRetorno = valor[linha][getIdColuna(coluna)];
		
		if(objRetorno instanceof Double)
		{
			DecimalFormatSymbols dfSimbol = new DecimalFormatSymbols();
			dfSimbol.setDecimalSeparator('.');

			DecimalFormat decimalFormat = new DecimalFormat( "#0.00");
			decimalFormat.setDecimalSeparatorAlwaysShown(true);
			decimalFormat.setDecimalFormatSymbols(dfSimbol);
			decimalFormat.applyPattern("#0.00");

			return decimalFormat.format(objRetorno);
		}
		
		return objRetorno==null?"":objRetorno.toString();
	}
	
	
	public Date getDate(int coluna,int linha)
	{
		Object objRetorno = valor[linha][coluna];
		return objRetorno==null?new Date():(Date)objRetorno;
	}
	
	public Date getDate(String coluna,int linha)
	{ 
		Object objRetorno = valor[linha][getIdColuna(coluna)];
		return objRetorno==null?new Date():(Date)objRetorno;
	}
	
	
	public int getIdColuna(String nomeColuna)
	{
		 int idColuna = -1;
		 
		loop:for(int i = 0;i <= iNumColuna; i++ )
		{
			if(valor_info[0][i].toString().equalsIgnoreCase(nomeColuna))
			{
				idColuna=i;
				break loop;
			} 
	
		}
		
		return idColuna;
	}
	
	public int getNumCols()
	{
		return this.iNumColuna;
	}
	
	public int getNumRows()
	{
		return this.iNumLinha;
	}
	 
	

class MyDialog extends JDialog 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5927119337943086313L;

	public MyDialog( JFrame frame, Object[] colunas , Object[][] linhas) 
	{
        super(frame, "Hello", true );
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       
        JTable table = new JTable( linhas, colunas );
        
      /*  JScrollPane  scroll = new JScrollPane(table);
        scroll.setBounds(10,60,780,500);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
         
         */
        
        JScrollPane scroll = new JScrollPane(table);
        JViewport viewport = new JViewport();
        viewport.setView(table);
        viewport.setPreferredSize(table.getPreferredSize());
        scroll.setRowHeaderView(viewport);
        scroll.setCorner(JScrollPane.UPPER_LEFT_CORNER, table.getTableHeader());
        frame.add(scroll);

        frame.setSize(300, 200);
        frame.setVisible(true); 
    } 

}

public void orderBy(String Coluna)
{
	orderBy(getIdColuna(Coluna));
}


public void orderBy(int Coluna)
{
	
	final int iColuna = Coluna;
	
	Arrays.sort(valor, new Comparator<Object[]>() 
		    {
		        @Override
		        public int compare(Object[] o1, Object[] o2) 
		        {
		        	final int iValor1 = Integer.parseInt(o1[iColuna].toString());
		        	final int iValor2 = Integer.parseInt(o2[iColuna].toString());	
	            
		        	
		        	if (iValor1 > iValor1) return 1;
		        	if (iValor1 < iValor2) return -1;
		        	return 0;    
		        }
		    });
}
	 
}
