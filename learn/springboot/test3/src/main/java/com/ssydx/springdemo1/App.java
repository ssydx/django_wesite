package com.ssydx.springdemo1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class App {
    public static void main(String[] args) {
        // 应用上下文容器
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld hw = (HelloWorld) context.getBean("helloWorld");
        hw.getMessage();
        // Bean工厂容器
        Resource resource = new ClassPathResource("beans.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        Student stu = (Student) factory.getBean("studentbean");
        stu.displayInfo();

        // 不含引用（basetype）类型的构造器注入
        Employee e1 = (Employee) context.getBean("e1");
        e1.show1();
        Employee e2 = (Employee) context.getBean("e2");
        e2.show1();
        Employee e3 = (Employee) context.getBean("e3");
        e3.show1();

        // 含引用（reftype）类型的构造器注入
        Employee e = (Employee) context.getBean("e");
        e.show2();

        // 含引用（List<basetype>）类型的构造器注入
        Question q1 = (Question) context.getBean("q1");
        q1.displayInfo1();

        // 含引用（List<reftype>）类型的构造器注入
        Question q2 = (Question) context.getBean("q2");
        q2.displayInfo2();

        // 含引用（List<basetype>）类型的构造器注入
        Question q3 = (Question) context.getBean("q3");
        q3.displayInfo3();

        // 含引用（List<reftype>）类型的构造器注入
        Question q4 = (Question) context.getBean("q4");
        q4.displayInfo4();


        // 不含引用（basetype）类型的setter注入
        Employee se1 = (Employee) context.getBean("se1");
        se1.show1();
        Employee se2 = (Employee) context.getBean("se2");
        se2.show1();
        Employee se3 = (Employee) context.getBean("se3");
        se3.show1();

        // 含引用（reftype）类型的setter注入
        Employee se = (Employee) context.getBean("se");
        se.show2();

        // 其他setter注入同理

        A clsa = context.getBean("clsa",A.class);
        clsa.display();

    }
}