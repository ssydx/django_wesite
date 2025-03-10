package com.ssydx.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.ssydx.jdbc.domain.User;

import lombok.val;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate template;

    public List<User> select() {
        return template.query("select * from user_info", (res,rw) -> {
            User user = new User();
            user.setId(res.getLong(1)).setName(res.getString("name")).setAge(res.getInt(3));
            return user;
        });
    }
    public int insert(User user) {
        return template.update("insert into user_info(name,age) values(?,?)", user.getName(),user.getAge());
    }
    public int update(User user) {
        return template.update("update user_info set name = ?,age = ? where id = ?", user.getName(),user.getAge(),user.getId());
    }
    public int delete(Long id) {
        return template.update("delete from user_info where id = ?", id);
    }

    public int update1(User user) {
        return template.update("insert into user_info(name,age) values(?,?)", pss -> {
            pss.setString(1, user.getName());
            pss.setInt(2, user.getAge());
        });
    }
    // public int update2(User user) {
    //     return template.update(new PreparedStatementCreator() {
    //         @Override
    //         public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                
    //         }
    //     });
    // }
}
