package com.ssydx.test5;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import com.ssydx.test5.entity.AuthorEntity;
import com.ssydx.test5.repository.AuthorDao;

@SpringBootTest
@ActiveProfiles("h21")
public class H2Test1 {
    // 测试数据源
    @Autowired
    private DataSource dataSource;
    @Test
    public void testDataSource() {
        try (Connection connection = dataSource.getConnection()) {
            DatabaseMetaData data = connection.getMetaData();
            System.out.println(data.getDriverName());
            System.out.println(data.getDriverVersion());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 测试模板
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    public void testJdbcTemplate() {
        System.out.println(jdbcTemplate.getDataSource());
        System.out.println(jdbcTemplate.getFetchSize());
    }
    // 测试DAO
    @Autowired
    private AuthorDao authorDao;
    @Test
    public void testAuthorDao() {
        authorDao.addAuthor(new AuthorEntity().setName("张三").setAge(Byte.valueOf("25")));
        authorDao.addAuthor(new AuthorEntity().setName("王五").setAge(Byte.valueOf("30")));
        authorDao.queryAll().forEach(System.out::println);
        authorDao.updateAuthor(new AuthorEntity(1L, "李四", Byte.valueOf("35")));
        System.out.println(authorDao.queryById(1L));
        authorDao.deleteAuthor(1L);
    }
}
