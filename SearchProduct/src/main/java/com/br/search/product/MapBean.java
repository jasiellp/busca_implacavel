package com.br.search.product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import com.br.search.product.teste.Car; 

@ManagedBean(name = "mapBean")
@ViewScoped
public class MapBean implements Serializable
{
	/** 
	 * 
	 */
	private static final long serialVersionUID = 89459996582054769L;
	private List<MapVO> mapList;
	private Car selectedCar;
	public String  valorFeliz = " google.visualization.arrayToDataTable( [['Ano', 'Sales', 'Expenses'],  ['2010',"+String.valueOf((Math.random()*100)/1000).replace(".", "") +",43],['2011',"+String.valueOf((Math.random()*100)/1000).replace(".", "") +",55],['2012',64,50], ['2013',"+String.valueOf((Math.random()*100)/1000).replace(".", "") +",43],['2014',"+String.valueOf((Math.random()*100)/1000).replace(".", "") +",55],['2015',64,50]   ]  ) ";  

	public String getValorFeliz()
	{ 
		return valorFeliz;
	}
	 /*oncomplete="drawChartl(#{mapBean.valorFeliz})" */


	public void setValorFeliz(String valorFeliz)
	{
		 
		
		this. valorFeliz=" google.visualization.arrayToDataTable( [['Ano', 'Sales', 'Expenses'],  ['2010',"+String.valueOf(Math.random()*100).replace(".", "") +",43],['2011',30,55],['2012',64,50], ['2013',82,43],['2014',30,55],['2015',64,50]   ]  ) ";
		//this.valorFeliz = valorFeliz;
	}
	
	 
	@PostConstruct
	public void init()
	{
	 
		mapList = new ArrayList<MapVO>();
		
		    
		setMapList(mapList);
	}
	
	public Car getSelectedCar()
	{
		 		return selectedCar;
	}

	public void setSelectedCar(Car selectedCar)
	{ 
		
		 
		 String valor = "";
		 double tx = Double.parseDouble( selectedCar.taxa);
		 
		 
		 double valor_aplicado = 1200,
				 valor_liquido  = 0,
				 valor_bruto = 0;
		 valorFeliz=" google.visualization.arrayToDataTable( [['Mes', 'Valor Bruto', 'Valor Liquido'], ";
		 
		 for(int i = 1; i <= 12 ; i++ )
		 {
			 valor_aplicado=valor_aplicado+(valor_aplicado*tx);
			 
			 valor_bruto= valor_aplicado;
			 
			 valor_liquido=valor_bruto-(valor_bruto*Math.random());
			 
			 if(i==12)
				 valor = " ['"+i+"',"+valor_bruto +","+valor_liquido+"] ";
			 else
				 valor = " ['"+i+"',"+valor_bruto +","+valor_liquido+"] ,";
			 
			 valorFeliz+=valor;
		 }
		 valorFeliz+="]  ) ";
		 
		 
		// valorFeliz=" google.visualization.arrayToDataTable( [['Ano', 'Sales', 'Expenses'],  ['.',"+String.valueOf((Math.random()*100)/1000).replace(".", "") +",43],['.',"+String.valueOf((Math.random()*100)/1000).replace(".", "") +",55],['.',64,50], ['.',"+String.valueOf((Math.random()*100)/1000).replace(".", "") +",43],['.',"+String.valueOf((Math.random()*100)/1000).replace(".", "") +",55],['.',64,50]   ]  ) ";
		 
		 RequestContext.getCurrentInstance().execute("drawChartl("+valorFeliz+");");
  		 
		this.selectedCar = selectedCar;
	}
	
	private HashMap<String, String> mapData;

	public HashMap<String, String> getMapData()
	{ 
		return mapData;
	}

	public void setMapData(HashMap<String, String> mapData)
	{
		
		this.mapData = mapData;
	}

	public List<MapVO> getMapList()
	{
		return mapList;
	}

	public void setMapList(List<MapVO> mapList)
	{
		this.mapList = mapList;
	}
	
	private String pieChartData = getPieChartData();
	
	private void populateData()
	{
		StringBuilder stringBuilder = new StringBuilder();
		 
		stringBuilder.append("[");
		stringBuilder.append("'");
		stringBuilder.append("2010");
		stringBuilder.append("'");
		stringBuilder.append(",");
		stringBuilder.append("");
		stringBuilder.append( String.valueOf(Math.random()*100).replace(".", "") );
		stringBuilder.append("");
		stringBuilder.append(",");
		stringBuilder.append("5000");
		stringBuilder.append("]");
		stringBuilder.append(",");
		stringBuilder.append("[");
		stringBuilder.append("'");
		stringBuilder.append("2011");
		stringBuilder.append("'");
		stringBuilder.append(","); 
		stringBuilder.append(String.valueOf(Math.random()*100).replace(".", ""));
		stringBuilder.append("");
		stringBuilder.append(",");
		stringBuilder.append("5000");
		stringBuilder.append("]");
		stringBuilder.append(",");
		stringBuilder.append("[");
		stringBuilder.append("'");
		stringBuilder.append("2012");
		stringBuilder.append("'");
		stringBuilder.append(","); 
		stringBuilder.append(String.valueOf(Math.random()*100).replace(".", ""));
		stringBuilder.append("");
		stringBuilder.append(",");
		stringBuilder.append("5000");
		stringBuilder.append("]");
		stringBuilder.append(",");
		
		pieChartData = pieChartData==null? stringBuilder.toString().substring(0, stringBuilder.toString().length() - 1): pieChartData+","+stringBuilder.toString().substring(0, stringBuilder.toString().length() - 1);
		  
	}
	
	public String getPieChartData()
	{
		if (pieChartData == null || pieChartData.trim().length() <= 0)
		{
			populateData();
		}
		
		return pieChartData;
	}
}
