package com.ssydx.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.ssydx.data.spingJdbc.UserDao2;
import com.ssydx.data.spingJdbc.UserDomain2;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class TestSpringJdbc {
    @Autowired
    private UserDao2 userDao;

    @Test
    public void testInsert1() {
        userDao.insert1(new UserDomain2("张三", "张三是一个热爱学习、尊师敬道的好学生", 578.0));
    }
    @Test
    public void testInsert2() {
        userDao.insert2(new UserDomain2("李四", "李四也是一个热爱学习的大学生", 93.7));
    }
    @Test
    public void testInsert3() {
        userDao.insert3(new UserDomain2("李四", "李四是一个大学教师", 77.76));
    }
    @Test
    public void testInsert4() {
        userDao.insert4(new UserDomain2("王五", "王五是刚工作的大学毕业生，充满活力", 87.33));
    }
    @Test
    public void testInsert5() {
        userDao.insert5(new UserDomain2("李梅", "李梅是某知名外企的在职员工", 92.2));
    }
    @Test
    public void testInsert6() {
        userDao.insert6(new UserDomain2("张雷", "张雷是某知名国企的劳务派遣员工", 85.6));
    }
    @Test
    public void testInsert7() {
        userDao.insert7(new UserDomain2("赵六", "赵六是某高中的高中教师", 73.5));
    }
    @Test
    public void testquery1() {
        testInsert1();
        testInsert2();
        testInsert3();
        testInsert4();
        testInsert5();
        testInsert6();
        testInsert7();
        userDao.query1().forEach(System.out::println);
    }
}
