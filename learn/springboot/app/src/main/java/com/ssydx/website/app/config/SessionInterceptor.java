package com.ssydx.website.app.config;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssydx.website.app.dao.SessionDao;
import com.ssydx.website.app.util.CookieUtil;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SessionInterceptor implements HandlerInterceptor {
    public  boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       if (CookieUtil.getCookieValue(request) == null) {
            response.sendRedirect("/login");
            return false;
       }
       return true;
   }
}
