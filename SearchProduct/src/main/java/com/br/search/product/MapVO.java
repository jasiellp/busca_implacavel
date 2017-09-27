package com.br.search.product;

public class MapVO
{
	public MapVO(String ano, String sales,String expenses)
	{
		super();
		this.ano = ano;
		this.sales = sales;
		this.expenses=expenses;
	}

	private String ano;
	private String sales;
	private String expenses;

	public String getExpenses()
	{
		return expenses;
	}

	public void setExpenses(String expenses)
	{
		this.expenses = expenses;
	}

	public String getAno()
	{
		return ano;
	}

	public void setAno(String ano)
	{
		this.ano = ano;
	}

	public String getSales()
	{
		return sales;
	}

	public void setSales(String sales)
	{
		this.sales = sales;
	}
}