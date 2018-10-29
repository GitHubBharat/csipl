package com.csipl.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DataSourceIntercetor extends HandlerInterceptorAdapter {
	 
    // Request:
 
    // /publisher/list
    // /advertiser/list
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
 
        String contextPath = request.getServletContext().getContextPath();
 
        // /SomeContextPath/company
        String prefixcompany = contextPath + "/company";
         
        // /SomeContextPath/employees
        String prefixEmployees = contextPath + "/employees";
 
        // /SomeContextPath/company/dashboard
        // /SomeContextPath/employees/dashboard
         
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