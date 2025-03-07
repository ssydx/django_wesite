package com.ssydx.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssydx.mybatis.domain.User;

@Repository
public class UserDao2Impl implements UserDao2 {
    @Autowired
    private SqlSession sqlSession;
    @Override
    public List<User> select() {
        return sqlSession.selectList("com.ssydx.mybatis.dao.UserDao2.select");
    }
    @Override
    public int insert(User user) {
        return sqlSession.insert("com.ssydx.mybatis.dao.UserDao2.insert", user);
    }
    @Override
    public int update(User user) {
        return sqlSession.update("com.ssydx.mybatis.dao.UserDao2.update", user);
    }
    @Override
    public int delete(Long id) {
        return sqlSession.delete("com.ssydx.mybatis.dao.UserDao2.delete", id);
    }
}
