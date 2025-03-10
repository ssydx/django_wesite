package com.ssydx.redis;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.ssydx.redis.dao.UserDao3;
import com.ssydx.redis.domain.User;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class UserDaoTest3 {
    @Autowired
    private UserDao3 userDao3;

    @Test
    public void testSave() {
        User user = new User(1, "zs", "zs", 34, 1L);
        Map<String,String> map = new HashMap<String,String>();
        Field[] fields = user.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                map.put(field.getName(), field.get(user).toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        userDao3.hmset(user.getId().toString(), map);
    }
    @Test
    public void testAge() {
        userDao3.customQuery(30).forEach(System.out::println);
    }

}
