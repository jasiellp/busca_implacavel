package com.br.search.product;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@SessionScoped
public class Home implements Serializable
{

	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4704698566405708239L;
	
	  
	private double number3 =  10000.0d;
	public String  pattern = "DD MM, YYYY";;
	
	public Date selectedDate = new Date();
	
	public boolean popup = true;
	
	
/*	@PostConstruct
	public void init()
	{
		try
		{
			WebLog.NovoLog("Home", Sessao.retrieveSessionId());
		}
		catch (Exception e)
		{
		 
		}
		
		

	}*/
	
	
	public boolean isPopup()
	{
		return popup;
	}
	public void setPopup(boolean popup)
	{
		this.popup = popup;
	}
	public double getNumber3()
	{
		return number3;
	}
	public void setNumber3(double number3)
	{
		this.number3 = number3;
	}
	public String getPattern()
	{
		return pattern;
	}
	public void setPattern(String pattern)
	{
		this.pattern = pattern;
	}
	public Date getSelectedDate()
	{
		return selectedDate;
	}
	public void setSelectedDate(Date selectedDate)
	{
		this.selectedDate = selectedDate;
	}

 
	
	public void redirect() throws IOException 
	{
	   
		
		  
		SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-mm-dd");
		System.out.println(dt1.format(selectedDate));
		System.out.println("Jasiel Voce é lindao"+  number3);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("number3", number3);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("selectedDate", selectedDate);
	     
	    FacesContext.getCurrentInstance().getExternalContext().redirect("cotacao");
	}
	
}
