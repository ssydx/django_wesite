package com.springboot.myblog.filter;

import java.io.IOException;
import java.util.Optional;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebFilter(urlPatterns = "/secret/*")
public class SessionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException,ServletException {
        Cookie[] cookies = Optional.ofNullable(((HttpServletRequest)servletRequest).getCookies()).orElse(new Cookie[0]);
        boolean unauthorized = true;
        for (Cookie cookie : cookies) {
            if ("sessionId".equals(cookie.getName()) && "test-token".equals(cookie.getValue())) {
                unauthorized = false;
                break;
            }
        }
        if (unauthorized) {
            log.error("未验证");
            unauthorizedResp(servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
    private void unauthorizedResp(ServletResponse response) throws IOException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpServletResponse.setHeader("Content-type", "text/html;charset=UTF-8");
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.getWriter().write("未验证");
    }
}
