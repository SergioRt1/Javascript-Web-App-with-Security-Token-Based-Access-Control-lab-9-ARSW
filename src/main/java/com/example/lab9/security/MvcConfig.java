package com.example.lab9.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/index.html").setViewName("index");
//        registry.addViewController("/").setViewName("index");
//        registry.addViewController("/register.html").setViewName("register");
//        registry.addViewController("/login.html").setViewName("login");
    }

}