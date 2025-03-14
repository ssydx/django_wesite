package com.ssydx.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;

import com.ssydx.data.springDataJdbc.UserDao3;
import com.ssydx.data.springDataJdbc.UserDomain3;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class TestSpringDataJdbc {
    @Autowired
    private UserDao3 userDao3;

    @Test
    public void test1() {
        userDao3.save(new UserDomain3("张三", "张三是一个热爱学习、尊师敬道的好学生", 578.0));
        userDao3.save(new UserDomain3("李四", "李四也是一个热爱学习的大学生", 93.7));
        userDao3.save(new UserDomain3("李四", "李四是一个大学教师", 77.76));
    }
    // 自定义接口
    @Test
    public void test2() {
        test1();
        userDao3.custom().forEach(System.out::println);
    }
    // 方法名生成查询
    @Test
    public void test3() {
        test1();
        userDao3.findByUserName("李四").forEach(System.out::println);
    }
    // Query注解
    @Test
    public void test4() {
        test1();
        userDao3.myfindAll().forEach(System.out::println);
    }
    // Query命名注解
    @Test
    public void test5() {
        test1();
        userDao3.myfindByScoreUseName(93.7).forEach(System.out::println);
    }
    // Query注解增删改
    @Test
    public void test6() {
        test1();
        userDao3.deleteByScore("李四");
        userDao3.findAll(Sort.by("score").ascending()).forEach(System.out::println);
    }
    @Test
    public void test7() {
        test1();
        userDao3.test("大学").forEach(System.out::println);
    }
    @Test
    public void test8() {
        test1();
        userDao3.findAll(Sort.by("score").ascending()).forEach(System.out::println);
    }
    @Test
    public void test9() {
        test1();
        Pageable pageable = PageRequest.of(0, 3, Sort.by("userName").ascending());
        userDao3.findAll(pageable).getContent().forEach(System.out::println);
    }
    @Test
    public void test10() {
        test1();
        UserDomain3 userDomain3 = new UserDomain3("李四", "学生", 0D);
        userDao3.findAll(Example.of(userDomain3, ExampleMatcher.matching().withIgnorePaths("score","userName").withMatcher("desc", GenericPropertyMatcher.of(StringMatcher.CONTAINING)))).forEach(System.out::println);
    }
}
