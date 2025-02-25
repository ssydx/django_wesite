package com.ssydx.springdemo2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.ssydx.springdemo2")
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        HelloWorld hw = context.getBean(HelloWorld.class);
        hw.setName("ssydx");
        hw.print();
    }
}
