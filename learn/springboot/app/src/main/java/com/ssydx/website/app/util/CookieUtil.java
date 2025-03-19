package com.ssydx.website.app.util;

import java.util.UUID;

import com.ssydx.website.app.redis.SessionRedis;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieUtil {
    public static String getSessionId(HttpServletRequest request) {
       Cookie[] cookies = request.getCookies();
       if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(SessionRedis.token)) {
                    return cookie.getValue();
                }
            }
       }
       return null;
    }
    public static String setSessionId(HttpServletResponse response) {
        String sessionId = UUID.randomUUID().toString();
        Cookie cookie = new Cookie(SessionRedis.token, sessionId);
        cookie.setMaxAge(SessionRedis.expiredSeconds);
        cookie.setPath("/");
        response.addCookie(cookie);
        return sessionId;
    }
    public static void resetSessionId(HttpServletResponse response, String sessionId) {
        Cookie cookie = new Cookie(SessionRedis.token, sessionId);
        cookie.setMaxAge(SessionRedis.expiredSeconds);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
