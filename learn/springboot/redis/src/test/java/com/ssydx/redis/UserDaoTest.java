package com.ssydx.redis;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.domain.Example;

import com.ssydx.redis.dao.UserDao;
import com.ssydx.redis.domain.User;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void testSaveWithId() {
        var user = new User().setId(1).setName("张三").setDescription("张三是个撒比").setAge(32).setTimeout(1L);
        userDao.save(user);
    }
    @Test
    public void testUpdateWithId() {
        userDao.findById(1).ifPresent(u -> {
            u.setName("李四");
            u.setDescription("李四也是个傻逼");
            userDao.save(u);
        });
    }
    @Test
    public void testQuery() {
        userDao.findByDescription("李四也是个傻逼").forEach(System.out::println);
    }
    @Test
    public void testDelete() {
        userDao.deleteById(1);
    }
    @ParameterizedTest
    @CsvSource({"zs,sb,32","ls,sb too,22"})
    public void testSave(String name, String description, int age) {
        var user = new User().setName(name).setDescription(description).setAge(age);
        userDao.save(user);
    }
    @ParameterizedTest
    @ValueSource(strings = {"zs"})
    public void testFindByName(String name) {
        userDao.findByName(name).forEach(System.out::println);
    }
    @ParameterizedTest
    @CsvSource({"ls,sb too"})
    public void testExample(String name, String description) {
        var user = new User().setName(name).setDescription(description);
        userDao.findAll(Example.of(user)).forEach(System.out::println);
    }
    @Test
    public void testQueryAll() {
        userDao.findAll().forEach(System.out::println);
    }
    @Test
    public void testDeleteAll() {
        userDao.deleteAll();
    }

}
