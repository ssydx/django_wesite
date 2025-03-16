package com.ssydx.website.app;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.ssydx.website.app.dao.ClazzMapper;
import com.ssydx.website.app.dao.UserMapper;
import com.ssydx.website.app.domain.Clazz;
import com.ssydx.website.app.domain.User;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class TestMyBatis {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ClazzMapper clazzMapper;
    @Test
    public void testFindAll() {
        userMapper.findAll().forEach(System.out::println);
    }
    @Test
    public void testSave() {
        Clazz clazz = clazzMapper.findById(2);
        User user = new User().setUserName("shisan").setUserPwd("shisan").setUserRegisterDate(new Date()).setUserLastLoginDate(new Date()).setUserLoginCount(1).setClazz(clazz);
        userMapper.save(user);
        System.out.println(user.getUserId());
        testFindAll();
    }
    @Test
    public void testRemove() {
        userMapper.remove(3L);
        testFindAll();
    }
    @Test
    public void testUpdate() {
        Clazz clazz = clazzMapper.findById(2);
        userMapper.update(new User(1L,"zhangsan","zhangsan1",new Date(),new Date(),2,clazz));
        testFindAll();
    }
    @Test
    public void testFind() {
        System.out.println(userMapper.find(2L));
    }
    @Test
    public void testFindAll1() {
        userMapper.findAll1().forEach(System.out::println);
    }
    @Test
    public void testFind1() {
        System.out.println(userMapper.find1(2L));
    }
    @Test
    public void testSave1() {
        Clazz clazz = clazzMapper.findById(2);
        User user = new User().setUserName("shisan").setUserPwd("shisan").setUserRegisterDate(new Date()).setUserLastLoginDate(new Date()).setUserLoginCount(1).setClazz(clazz);
        userMapper.save(user);
        System.out.println(user.getUserId());
        testFindAll();
    }
    @Test
    public void testRemove1() {
        userMapper.remove(3L);
        testFindAll();
    }
    @Test
    public void testUpdate1() {
        Clazz clazz = clazzMapper.findById(2);
        userMapper.update(new User(1L,"zhangsan","zhangsan1",new Date(),new Date(),2,clazz));
        testFindAll();
    }
    @Test
    public void testFindById() {
        System.out.println(clazzMapper.findById(2));
    }
    @Test
    public void testFindByClazzId() {
        userMapper.findByClazzId(1).forEach(System.out::println);
    }
    @Test
    public void testFindAllUsers() {
        clazzMapper.findAllUsers().forEach(System.out::println);
    }
}
