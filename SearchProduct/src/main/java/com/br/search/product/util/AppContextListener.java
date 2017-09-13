package com.br.search.product.util;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {

@Override
public void contextDestroyed(ServletContextEvent event) {

}

@Override
public void contextInitialized(ServletContextEvent event) {
  System.getProperties().put("org.apache.el.parser.COERCE_TO_ZERO", "false");  	

}
}