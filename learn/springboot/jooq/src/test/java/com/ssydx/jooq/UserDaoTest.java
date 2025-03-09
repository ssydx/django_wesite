package com.ssydx.jooq;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.transaction.annotation.Transactional;

import com.ssydx.jooq.dao.UserDao;
import com.ssydx.jooq.domain.tables.records.UserInfoRecord;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class UserDaoTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void testSelect() {
        userDao.select().forEach(System.out::println);
    }
    @Transactional
    @ParameterizedTest
    @CsvSource({"李四,20","王五,55"})
    public void testInsert(String name, int age) {
        UserInfoRecord userInfoRecord = new UserInfoRecord();
        userInfoRecord.setName(name);
        userInfoRecord.setAge(age);
        userDao.insert(userInfoRecord);
        testSelect();
    }

}
