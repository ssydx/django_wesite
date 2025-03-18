package com.ssydx.website.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssydx.website.app.dao.RedisDao;
import com.ssydx.website.app.redis.SessionRedis;
import com.ssydx.website.app.util.CookieUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SessionInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisDao redisDao;
    public  boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            AccessLimit accessLimit = handlerMethod.getMethodAnnotation(AccessLimit.class);
            if (accessLimit != null) {
                if (!redisDao.isExist(SessionRedis.prefix, CookieUtil.getCookieValue(request))) {
                    response.sendRedirect("/login");
                    return false;
                }
            }
        }
       return true;
   }
}
