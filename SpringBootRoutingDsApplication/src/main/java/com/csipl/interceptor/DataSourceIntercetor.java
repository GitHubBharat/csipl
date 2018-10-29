package com.csipl.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DataSourceIntercetor extends HandlerInterceptorAdapter {
	 
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
 
        String contextPath = request.getServletContext().getContextPath();
 
        String prefixcompany = contextPath + "/company";
         
      
        String prefixEmployees = contextPath + "/employees";
 
          
        String uri = request.getRequestURI();
        System.out.println("URI:"+ uri);
         
        if(uri.startsWith(prefixcompany)) {
            request.setAttribute("keyDS", "COMPANY_DS");
        }
         
        else if(uri.startsWith(prefixEmployees)) {
            request.setAttribute("keyDS", "EMPLOYEES_DS");
        }
 
        return true;
    }
 
}