package com.br.search.product;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@RequestScoped
public class MyBean {
    public void execute() {
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String txtProperty = request.getParameter("myForm:txt3");
        //note the difference when getting the parameter
        String txtAnotherProperty= request.getParameter("txtAnotherProperty");
        //use the value in txtProperty as you want...
        //Note: don't use System.out.println in production, use a logger instead
        System.out.println(txtProperty);
        System.out.println(txtAnotherProperty);
    }
}