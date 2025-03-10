package com.ssydx.mongodb;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.ssydx.mongodb.dao.UserDao;
import com.ssydx.mongodb.dao.UserDao1;
import com.ssydx.mongodb.domain.User;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class UserDaoTest {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserDao1 userDao1;

    @Test
    public void testSave() {
        userDao.save(new User("1","zs","zs sb",25));
    }
    @Test
    public void testDelete() {
        userDao.deleteAll();
    }
    @ParameterizedTest
    @CsvSource({"ls,ls,30","ww,ww,32"})
    public void testSaveAll(String name,String desp,int age) {
        userDao.save(new User().setName(name).setDescription(desp).setAge(age));
    }
    @Test
    public void testGet() {
        userDao1.get().forEach(System.out::println);
    }
}
