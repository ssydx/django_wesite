package com.ssydx.securtiy.handler;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssydx.securtiy.common.Result;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AllSecurityHandler implements AuthenticationSuccessHandler,AuthenticationFailureHandler,LogoutSuccessHandler,AccessDeniedHandler {
    private ObjectMapper objectMapper = new ObjectMapper();
    
    private void writeResponse(HttpServletResponse response, String json) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(json);
        writer.flush();
        writer.close();
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        Result result = new Result<>(200, "登录成功",authentication);
        String json = objectMapper.writeValueAsString(result);
        writeResponse(response, json);
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {
        Result result = new Result<>(200, "登录失败",exception);
        String json = objectMapper.writeValueAsString(result);
        writeResponse(response, json);
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException accessDeniedException) throws IOException, ServletException {
        Result result = new Result<>(200, "没有权限",accessDeniedException);
        String json = objectMapper.writeValueAsString(result);
        writeResponse(response, json);
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        Result result = new Result<>(200, "退出成功",authentication);
        String json = objectMapper.writeValueAsString(result);
        writeResponse(response, json);
    }

}
