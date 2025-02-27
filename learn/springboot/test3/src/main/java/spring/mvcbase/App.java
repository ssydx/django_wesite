package spring.mvcbase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-servlet.xml");
        EmployeeDao e = (EmployeeDao) context.getBean("dao");
        System.out.println(e.getEmps());
        System.out.println(e.getById(1));
        Employee e1 = new Employee();
        e1.setId(104);
        e1.setName("ssydx");
        e1.setAge(50);;
        // System.out.println(e.update(e1));
    }
}
