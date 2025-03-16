package com.ssydx.shizhan.access;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssydx.shizhan.controller.CookieUtil;
import com.ssydx.shizhan.controller.UserController;
import com.ssydx.shizhan.redis.RedisUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AccessInterceptor implements HandlerInterceptor {
    private final UserController userController;
    private final RedisUtil redisUtil;
    public AccessInterceptor(UserController userController,RedisUtil redisUtil) {
        this.userController = userController;
        this.redisUtil = redisUtil;
    }
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        CookieUtil.getSessionId(request, response);
        return true;
    }
}
