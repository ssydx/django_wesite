package com.ssydx.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ssydx.mybatis.domain.User;

@Mapper
public interface UserDao1 {
    @Select(value = "select * from user_info")
    List<User> select();
    @Insert("insert into user_info(name,age) values(#{name}, #{age})")
    int insert(User user);
    @Update("update user_info set name = #{name},age = #{age} where id = #{id}")
    int update(User user);
    @Delete("delete from user_info where id = #{id}")
    int delete(Long id);
}
