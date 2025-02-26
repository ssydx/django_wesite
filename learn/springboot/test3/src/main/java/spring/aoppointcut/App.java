package spring.aoppointcut;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        Operation1 o1 = (Operation1) context.getBean("o1");
        Operation2 o2 = (Operation2) context.getBean("o2");
        o1.method1();
        o1.method2();
        o1.method3("a");
        o1.method4(1);
        o1.method5(1,"a");
        o1.method6("a",1);
        o2.method1();
        o2.method2();
        o2.method3("a");
        o2.method4(1);
        o2.method5(1,"a");
        o2.method6("a",1);
    }
}
