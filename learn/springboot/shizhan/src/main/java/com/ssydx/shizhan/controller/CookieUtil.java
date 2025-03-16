package com.ssydx.shizhan.controller;

import java.util.UUID;

import com.ssydx.shizhan.redis.UserKey;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieUtil {
    // 设置cookie
    public static void addSessionId(HttpServletResponse response, String token) {
        Cookie cookie = new Cookie(UserKey.COOKIE_NAME_TOKEN, token);
        cookie.setMaxAge(UserKey.token.expireSeconds());
        cookie.setPath("/");
        response.addCookie(cookie);
    }
    // 获取cookie
    public static String getCookieValue(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length <= 0) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)) {
                return cookie.getValue();
            }
        }
        return null;
    }
    public static String getSessionId(HttpServletRequest request,HttpServletResponse response) {
        String token = CookieUtil.getCookieValue(request, UserKey.COOKIE_NAME_TOKEN);
        if (token == null) {
            token = UUID.randomUUID().toString().replace("-", "");
            addSessionId(response, token);
        }
        return token;
    }
}
