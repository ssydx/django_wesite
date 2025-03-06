package com.ssydx.data1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ssydx.data1.dao.UserDao1;
import com.ssydx.data1.dao.UserDao2;
import com.ssydx.data1.dao.UserDao3;
import com.ssydx.data1.dao.UserDao4;
import com.ssydx.data1.entity.User;

// @Service
public class UserService1 implements CommandLineRunner {
    @Autowired
    private UserDao1 userDao1;
    @Autowired
    private UserDao2 userDao2;
    @Autowired
    private UserDao3 userDao3;
    @Autowired
    private UserDao4 userDao4;
    @Override
    public void run(String... args) {
        testSave();
        testSaveAll();
        testFindAll();
        testFindById();
        testFindAllById();
        testExistsById();
        testDeleteById();
        testDeleteAllById();
        testDelete();
        testDeleteAll();
        testFindAll();
        testDeleteAll2();
        testFindAll();

        testSave();
        testSaveAll();
        testFindAllSort();
        testFindAllPage();

        testSaveAllList();
        testFindAllList();
    }
    public void testSave() {
        System.out.println("单个插入");
        for (int i = 1; i < 6; i++) {
            User user = new User().setName("user" + i).setGender('m').setAge(30 + i);
            userDao1.save(user);
        }
    }
    public void testSaveAll() {
        System.out.println("批量插入");
        List<User> users = new ArrayList<User>();
        for (int i = 1; i < 11; i++) {
            User user = new User().setName("user-" + i).setGender('f').setAge(20 + i);
            users.add(user);
        }
        userDao1.saveAll(users);
    }
    public void testFindAll() {
        System.out.println("查找所有" + userDao1.count());
        userDao1.findAll().forEach(System.out::println);
    }
    public void testFindById() {
        System.out.println("查找单个Id");
        userDao1.findById(10).ifPresent(System.out::println);
    }
    public void testFindAllById() {
        System.out.println("查找多个Id");
        userDao1.findAllById(List.of(3,6,9)).forEach(System.out::println);
    }
    public void testExistsById() {
        System.out.println("查找Id是否存在");
        System.out.println(userDao1.existsById(5));
    }
    public void testDeleteById() {
        System.out.println("根据Id删除");
        userDao1.deleteById(1);
    }
    public void testDelete() {
        System.out.println("根据对象删除");
        userDao1.delete(new User(3,"user3",'m',33));
    }
    public void testDeleteAllById() {
        System.out.println("根据多个Id删除");
        userDao1.deleteAllById(List.of(6,7,8));
    }
    public void testDeleteAll() {
        System.out.println("根据多个对象删除");
        userDao1.deleteAll(List.of(new User(9, "user-9", 'f', 24),new User(10, "user-10", 'f', 25)));
    }
    public void testDeleteAll2() {
        System.out.println("删除所有");
        userDao1.deleteAll();
    }



    public void testFindAllSort() {
        System.out.println("排序查找");
        userDao2.findAll(Sort.by("age")).forEach(System.out::println);
    }
    public void testFindAllPage() {
        System.out.println("分页查找");
        Pageable page = PageRequest.of(7, 3, Sort.by("name").descending());
        Page<User> p = userDao2.findAll(page);
        p.getContent().forEach(System.out::println);
        System.out.println(p.getSize());
    }

    public void testSaveAllList() {
        System.out.println("批量插入，返回对象列表");
        List<User> users = new ArrayList<User>();
        for (int i = 1; i < 11; i++) {
            User user = new User().setName("user-" + i).setGender('m').setAge(20 + i);
            users.add(user);
        }
        System.out.println(userDao3.saveAll(users).size());
        // 其他同理
    }

    public void testFindAllList() {
        System.out.println("排序查找，返回对象列表");
        userDao4.findAll(Sort.by("gender").descending()).forEach(System.out::println);
    }
}
