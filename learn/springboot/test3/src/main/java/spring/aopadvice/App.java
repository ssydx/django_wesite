package spring.aopadvice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        Operation o = (Operation)context.getBean("o");
        o.before1();
        o.after1();
        try {
            o.after2();
        } catch (Exception e) {
            
        }
        o.around1();
    }
    
}
