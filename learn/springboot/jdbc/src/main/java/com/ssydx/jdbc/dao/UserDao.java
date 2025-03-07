package com.ssydx.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ssydx.jdbc.domain.User;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate template;
    public int insert(User user) {
        return template.update("insert into user_info(name,age) values(?,?)", user.getName(),user.getAge());
    }
    public List<User> select() {
        return template.query("select * from user_info", (res,rw) -> {
            User user = new User();
            user.setId(res.getLong(1)).setName(res.getString("name")).setAge(res.getInt(3));
            return user;
        });
    }
    public int update(User user) {
        return template.update("update user_info set name = ?,age = ? where id = ?", user.getName(),user.getAge(),user.getId());
    }
    public int delete(Long id) {
        return template.update("delete from user_info where id = ?", id);
    }
}
