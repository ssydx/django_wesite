package com.ssydx.config.controller;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ssydx.config.Dog;

import com.ssydx.config.config.Property;

import net.ssydx.config.Cat;

@Controller
public class HelloController {
    @Autowired
    private DateFormat dateFormat;
    @Autowired
    private Cat cat;
    @Autowired
    private Dog dog;
    @Value("${ssydx}")
    private String ssydx;
    @Value("${zhangsan}")
    private String zhangsan;
    @Autowired
    private Property property; 
    
    @RequestMapping("/")
    @ResponseBody
    public Property play() {
        return property;
    }
    // public String play() {
    //     return cat.bark() + " " + dog.bark() + " " + dateFormat.format(new Date()) + " " + ssydx + " " + zhangsan;
    // }
}
