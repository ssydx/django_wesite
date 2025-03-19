package com.ssydx.website.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssydx.website.app.redis.SessionRedis;
import com.ssydx.website.app.util.CookieUtil;
import com.ssydx.website.app.dao.RedisDao;
import com.ssydx.website.app.domain.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SessionInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisDao redisDao;

    public  boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            // 非控制器方法
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        AccessLimit accessLimit = handlerMethod.getMethodAnnotation(AccessLimit.class);
        // 无访问限制
        if (accessLimit == null) {
            return true;
        }

        String sessionId = CookieUtil.getSessionId(request);
        // sessionId存在
        if (sessionId == null) {
            // 是控制器方法且有访问限制且sessionId不存在
            response.sendRedirect("/user/login");
            return false;
        }
        
        User user = redisDao.get(SessionRedis.prefix, sessionId, User.class);
        // 会话ID有效
        if (user != null) {
            UserContext.setUser(user);
            return true;
        } else {
            // 是控制器方法且有访问限制且会话ID失效
            response.sendRedirect("/user/login");
            return false;
        }
   }
}
