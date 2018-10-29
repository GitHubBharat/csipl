package com.csipl.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.csipl.interceptor.DataSourceIntercetor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
 
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
 
        registry.addInterceptor(new DataSourceIntercetor())//
                .addPathPatterns("/company/*", "/employees/*");
    }
 
}