package com.ssydx.test5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class testController {
    @Autowired
    private WebServerApplicationContext wsac;
    @GetMapping("/test")
    public String test(Model model) {
        int port = wsac.getWebServer().getPort();
        System.out.println(port);
        model.addAttribute("port", port);
        return "test";
    }
}
