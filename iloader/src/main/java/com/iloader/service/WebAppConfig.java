package com.iloader.service;


import javax.servlet.MultipartConfigElement;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import org.springframework.boot.context.embedded.MultipartConfigFactory;

import com.iloader.bo.CopyToD;




@Configuration  
@EnableWebMvc 
@ComponentScan("com.iloader.repository")  


public class WebAppConfig {  

  
    @Bean  
    public CommonsMultipartResolver multipartResolver() {  
        return new CommonsMultipartResolver();  
    }  
    
    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("1024KB");
        factory.setMaxRequestSize("1024KB");
        return factory.createMultipartConfig();
    }
  
    @Bean  
    public UrlBasedViewResolver setupViewResolver() {  
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();  
        resolver.setPrefix("/WEB-INF/pages/");  
        resolver.setSuffix(".jsp");  
        resolver.setViewClass(JstlView.class);  
        return resolver;  
    }  
  
    @Bean  
    public CopyToD copyToD() {  
    	CopyToD copyToD = new CopyToD();  
        return copyToD;  
    }
    
    
    
}  

