package com.ssydx.test5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ssydx.test5.web.WebFilter;
import com.ssydx.test5.web.WebListener;

import jakarta.servlet.Filter;
import jakarta.servlet.ServletContextListener;

@Configuration
public class WebConfig1 {
    @Bean
    public ServletContextListener createListener() {
        return new WebListener();
    }
    @Bean
    public Filter createFilter() {
        return new WebFilter();
    }
}
