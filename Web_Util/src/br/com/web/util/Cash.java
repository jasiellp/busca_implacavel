package br.com.web.util;

import java.util.ArrayList;

public class Cash 
{	
	private static Cash tsboCash = null;
	static ArrayList<Sophia> value;
	

	

	private Cash()
	{
		value = new ArrayList<>();
	}

	public static Cash NovaVariavel()
	{	
		return tsboCash==null ? new Cash() : tsboCash;
	}

	
	public static ArrayList<Sophia> getValue() 
	{
		return value;
	}
	
	private static Object getCashObgect(String sVarName)
	{
		Sophia sophia_ = null;
		
		if(tsboCash == null)
		{
			tsboCash = new Cash();
		}

		loop : for(Sophia sophia: value)
		{
			if(sophia.getsVarName().trim().equalsIgnoreCase(sVarName))
			{
				sophia_ = sophia;
				
				break loop;
			}
		}
		
		
		return sophia_==null?null:sophia_.var;
	}


	public static String getCashString(String sVarName)
	{
		Object objeto = getCashObgect(sVarName);
		
		return objeto==null?null:objeto.toString();
	}


	public static void setCashString(String sVarName,String svalor)
	{
		int index = -1;
		
		loop : for(int i = 0; i <= value.size(); i++)
		{
			if(value.get(i).getsVarName().trim().equalsIgnoreCase(svalor))
			{
				index = i;
				break loop;	
			}
		
		}
		
		if(index > 0)
		{
			value.get(index).setsVarName(sVarName);
			value.get(index).setVar(svalor);
		}
		else
		{	
			value.add(new Sophia(sVarName, svalor));	
		}	
	}


	static class Sophia
	{
		private String sVarName = "";
		private Object var= null;
		
		public Sophia(String sVarName,Object var)
		{
			this.sVarName=sVarName;
			this.var=var;
		}
		
		
		public void setsVarName(String sVarName) 
		{
			this.sVarName = sVarName;
		}


		public void setVar(Object var) 
		{
			this.var = var;
		}

		
		public String getsVarName() 
		{
			return sVarName;
		}

		public Object getVar() 
		{
			return var;
		}
		
	}



}