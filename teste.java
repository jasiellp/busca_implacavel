package com.teste.rs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import java.util.Base64;

public class TClass
{

	public static void main(String[] args)
	{
		try
		{
			//System.out.println(encodeFileToBase64Binary("/Users/jasiellp/Downloads/Teste.zip"));
			
			Txt(encodeFileToBase64Binary("/Users/jasiellp/Downloads/Teste/tss.zip"), "/Users/jasiellp/Downloads/Teste/tss.txt");
			
			System.out.println("Final");
			
		} 
		catch (Exception e)
		{
		    System.out.println(e.getMessage());
		}


	}

	private static String encodeFileToBase64Binary(String fileName) throws IOException
	{ 
		return Base64.getEncoder().encodeToString(loadFile(new File(fileName)));
		
	}

	@SuppressWarnings("resource")
	private static byte[] loadFile(File file) throws IOException
	{
		InputStream is = new FileInputStream(file);

		long length = file.length();
		
		if (length > Integer.MAX_VALUE)
		{
			// File is too large
		}
		
		byte[] bytes = new byte[(int) length];

		int offset = 0, numRead = 0;

		while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0)
		{
			offset += numRead;
		}

		if (offset < bytes.length)
		{
			throw new IOException("Could not completely read file ".concat(file.getName()));
		}

		is.close();
		
		return bytes;
	}
	
	
	
	
	public static void Txt(String yourstring , String yourfilename)
	{
		BufferedWriter writer = null;
		
		try
		{
		
			writer = new BufferedWriter( new FileWriter( yourfilename));
			
		    writer.write( yourstring);

		}
		catch (IOException e)
		{
			 System.out.println(e.getMessage());
		}
		finally
		{
		    try
		    {
		        if ( writer != null)
		        {
		        	writer.close();
		        }
		    }
		    catch (IOException e)
		    {
		    	 System.out.println(e.getMessage());
		    }
		}
	}
}
