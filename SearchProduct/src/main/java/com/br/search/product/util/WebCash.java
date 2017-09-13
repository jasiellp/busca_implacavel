package com.br.search.product.util;

import java.beans.PropertyVetoException;
import java.net.URI;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class WebCash
{ 
			private static DataSource ds = null; 
			 
			
			public static WebConexao getConexao() throws Exception
			{ 
				
				if(ds == null)
				{	
					ds = setupDataSource();	
				}
				 
				return new WebConexao(ds);
			}
			 
			
			
			private static DataSource setupDataSource() throws Exception
		    {
				WebLog.logInfo(" Iniciando Pool de Conexao."); 
		     
				URI dbUri = new URI("postgres://qzzzemalgcxuej:6597e9b3e7709149a4c679e7dce21e7abb82024fb0ddcddba2241a9a8c214636@ec2-184-73-167-43.compute-1.amazonaws.com:5432/d35kk2dfeplt80");

		        String username = dbUri.getUserInfo().split(":")[0];
		        String password = dbUri.getUserInfo().split(":")[1];
		        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
		        String driver = "org.postgresql.Driver";
		     
				
		  	  	ComboPooledDataSource cpds = new ComboPooledDataSource();
		  	  
		        try 
		        {
		        	 cpds.setDriverClass(driver);
		        } 
		        catch (PropertyVetoException e) 
		        {
		            e.printStackTrace();
		        }
		        cpds.setJdbcUrl(dbUrl+"?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory");
		        cpds.setUser(username);
		        cpds.setPassword(password);
		        cpds.setMinPoolSize(1);
		        cpds.setAcquireIncrement(1);
		        cpds.setMaxPoolSize(10); 
		        cpds.setMaxStatements(50); 
		        cpds.setCheckoutTimeout(20000); 
		        cpds.setMaxIdleTime(900);
		        cpds.setIdleConnectionTestPeriod(3000); 
		        
		        
		        return cpds;
		    }
}
