package spring.aopxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        Operation o4 = (Operation)context.getBean("o4");
        o4.before1();
        o4.after1();
        try {
            o4.after2();
        } catch (Exception e) {
            
        }
        o4.around1();
    }
    
}
