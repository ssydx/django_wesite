package com.ssydx.config;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class Test1 {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate template;
    
    @Test
    @Transactional
    public void test11() {
        try {
            System.out.println(dataSource.getConnection().getMetaData().getURL());
        } catch (Exception e) {
            // TODO: handle exception
        }
        template.update("insert into user_info(name,age) values(?,?)", "zs",30);
        template.query("select * from user_info", (res,rc) -> {
            return res.getString("name") + ": " + res.getInt("age");
        }).forEach(System.out::println);
    }
}
