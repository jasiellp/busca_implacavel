package br.com.web.util;

import java.util.Date;
import java.util.Vector;

import br.com.web.util.exception.TsboException;

public class TsboVector
{

	public static int[] vectorToArrayInt(Vector<Integer> vector) throws Exception
	{
		try
		{
			int iCount = 0;
			
			int iArray[] = new int[vector.size()];
			
			for (int value: vector)
			{
				iArray[iCount++] = value;
			}
			
			return iArray;
		}
		catch (Exception e)
		{
			TsboException.treatError(e);
		}
		
		return null;
	}
	
	public static String[] vectorToArrayString(Vector<String> vector) throws Exception
	{
		try
		{
			int iCount = 0;
			
			String sArray[] = new String[vector.size()];
			
			for (String value: vector)
			{
				sArray[iCount++] = value;
			}
			
			return sArray;
		}
		catch (Exception e)
		{
			TsboException.treatError(e);
		}
		
		return null;
	}
	
	public static Double[] vectorToArrayDouble(Vector<Double> vector) throws Exception
	{
		try
		{
			int iCount = 0;
			
			Double dArray[] = new Double[vector.size()];
			
			for (Double value: vector)
			{
				dArray[iCount++] = value;
			}
			
			return dArray;
		}
		catch (Exception e)
		{
			TsboException.treatError(e);
		}
		
		return null;
	}
	
	public static Date[] vectorToArrayDate(Vector<Date> vector) throws Exception
	{
		try
		{
			int iCount = 0;
			
			Date dArray[] = new Date[vector.size()];
			
			for (Date value: vector)
			{
				dArray[iCount++] = value;
			}
			
			return dArray;
		}
		catch (Exception e)
		{
			TsboException.treatError(e);
		}
		
		return null;
	}
	
	public static Object[] vectorToArrayObject(Vector<Object> vector) throws Exception
	{
		try
		{
			int iCount = 0;
			
			Object dArray[] = new Object[vector.size()];
			
			for (Object value: vector)
			{
				dArray[iCount++] = value;
			}
			
			return dArray;
		}
		catch (Exception e)
		{
			TsboException.treatError(e);
		}
		
		return null;
	}
}
