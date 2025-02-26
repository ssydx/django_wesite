package spring.jdbctemplate;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
        PeopleDao1 pDao = (PeopleDao1)context.getBean("pdao1");
        int status1 = pDao.savePeo(new People(10,"ts",40));
        System.out.println(status1);
        int status2 = pDao.deletePeo(new People(10,"ts",40));
        System.out.println(status2);
        // int status3 = pDao.updatePeo(new People(4, "猪八戒", 1225));
        // System.out.println(status3);
        // boolean status4 = pDao.insertPeo1(new People(5, "ss", 80));
        // System.out.println(status4);
        // List<People> ls1 = pDao.getPeo1();
        // System.out.println(ls1);
        // List<People> ls2 = pDao.getPeo2();
        // System.out.println(ls2);

        // PeopleDao2 pDao2 = (PeopleDao2)context.getBean("pdao2");
        // int status5 = pDao2.insertPeo2(new People(10,"孙悟空",555));
        // System.out.println(status5);


    }
}
