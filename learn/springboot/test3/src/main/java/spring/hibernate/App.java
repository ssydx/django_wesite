package spring.hibernate;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
        PeopleDao pdao = (PeopleDao)context.getBean("pdao3");
        People p = new People();
        p.setId(100);
        p.setName("悟饭");
        p.setAge(13);
        // pdao.insertPeo1(p);
        // pdao.deletePeo1(p);
        // List<People> ls = pdao.getPeos();
        // System.out.println(ls);
    }
}
