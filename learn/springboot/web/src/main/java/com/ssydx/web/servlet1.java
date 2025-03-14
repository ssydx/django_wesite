package com.ssydx.web;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Value;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class servlet1 extends HttpServlet {
    @Value("${ssydx.greeting}")
    private String greeting;

    @Override
    public void doGet(HttpServletRequest req ,HttpServletResponse res) throws ServletException,IOException {
        res.setContentType("text/html");
        res.setCharacterEncoding("utf-8");
        PrintWriter pw = res.getWriter();
        pw.println("第一个信息" + greeting);
    }
}
