package com.ssydx.test5.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class WebListener implements ServletContextListener {
    private static final Logger LOG = LoggerFactory.getLogger(WebFilter.class);
    public void contextInitialized(ServletContextEvent sce) {
        LOG.info("---WEB init---");
    }
    public void contextDestroyed(ServletContextEvent sce) {
        LOG.info("---WEB dest---");
    }
}
