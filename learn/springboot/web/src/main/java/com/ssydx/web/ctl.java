package com.ssydx.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController
// public class ctl {
//     @Autowired
//     private WebServerApplicationContext ctx;
//     @Autowired
//     private ApplicationContext ac;

//     @GetMapping("/")
//     public String play() {
//         return "端口号为：" + ctx.getWebServer().getPort();
//     }
// }
