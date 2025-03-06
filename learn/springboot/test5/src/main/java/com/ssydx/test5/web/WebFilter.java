package com.ssydx.test5.web;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class WebFilter implements Filter {
    private static final Logger LOG = LoggerFactory.getLogger(WebFilter.class);
    public void doFilter(ServletRequest requ, ServletResponse resp, FilterChain filterchain) throws IOException,ServletException {
        LOG.info("hander before");
        filterchain.doFilter(requ, resp);
        LOG.info("hander after");
    }
}
