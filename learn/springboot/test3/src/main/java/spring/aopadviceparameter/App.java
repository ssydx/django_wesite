package spring.aopadviceparameter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        Operation o3 = (Operation)context.getBean("o3");
        o3.before1();
        o3.after1();
        try {
            o3.after2();
        } catch (Exception e) {
            
        }
        o3.around1();
    }
    
}
