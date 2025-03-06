package com.ssydx.test5.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ssydx.test5.entity.AuthorEntity;
@Repository
public class AuthorDao {
    @Autowired
    private JdbcTemplate template;
    public Long addAuthor(AuthorEntity authorEntity) {
        KeyHolder key = new GeneratedKeyHolder();
        template.update(connection -> {
        PreparedStatement ps = connection.prepareStatement(
            "insert into author_table(author_name, age) values(?, ?)", 
            Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, authorEntity.getName());
            ps.setInt(2, authorEntity.getAge());
            return ps;            
        },key);
        return key.getKey().longValue();
    }
    public int deleteAuthor(Long id) {
        return template.update(
            "delete from author_table where id=?", 
            id
        );
    }
    public int updateAuthor(AuthorEntity authorEntity) {
        return template.update(
            "update author_table set author_name=?,age=? where id=?", 
            authorEntity.getName(),authorEntity.getAge(),authorEntity.getId()
        );
    }
    public List<AuthorEntity> queryAll() {
        return template.query(
            "select * from author_table", 
            (rec,rw) -> {
                AuthorEntity authorEntity = new AuthorEntity();
                authorEntity.setId(rec.getLong("id"));
                authorEntity.setName(rec.getString("author_name"));
                authorEntity.setAge(rec.getByte("age"));
                return authorEntity;
            }
        );
    }
    public AuthorEntity queryById(Long id) {
        return template.queryForObject(
            "select * from author_table where id=?",
            (rec,rw) -> {
                AuthorEntity authorEntity = new AuthorEntity();
                authorEntity.setId(rec.getLong("id"));
                authorEntity.setName(rec.getString("author_name"));
                authorEntity.setAge(rec.getByte("age"));
                return authorEntity;
            },
            id
        );
    }
}
