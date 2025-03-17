package com.ssydx.website.app.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieUtil {
    public static String getCookieValue(HttpServletRequest request) {
       Cookie[] cookies = request.getCookies();
       if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    return cookie.getValue();
                }
            }
       }
       return null;
    }
    public static void addSessionId(HttpServletResponse response, String sessionId) {
        Cookie cookie = new Cookie("token", sessionId);
        cookie.setMaxAge(1800);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
