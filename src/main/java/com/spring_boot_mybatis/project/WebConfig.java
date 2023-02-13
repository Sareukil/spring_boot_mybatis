package com.spring_boot_mybatis.project;

import javax.servlet.annotation.WebServlet;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // TODO Auto-generated method stub
        registry.addResourceHandler("/images/**")
        .addResourceLocations("file:///usr/local/project/product_images/");

       /* registry.addResourceHandler("/images/**")
        .addResourceLocations("file:///C:/springWorkspace/product_images/",
                                                "file:///C:/springWorkspace/upload/");*/
                                                
        registry.addResourceHandler("/audio/**")
        .addResourceLocations("file:///C:/springWorkspace/upload/");
    }
    

}
