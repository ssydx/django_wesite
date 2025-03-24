package com.ssydx.securtiy.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ssydx.securtiy.domain.User;

@Mapper
public interface UserMapper {
    @Select("select u.*,a.authority from users u left join authorities a using(username) where username = #{username}")
    @Results(id = "mymap", value = {
        @Result(property = "username", column = "username"),
        @Result(property = "password", column = "password"),
        @Result(property = "enabled", column = "enabled"),
        @Result(property = "authority", column = "authority")
    })
    public User getUser(String username);

    @Insert("insert into users(username,password,enabled) values(#{username},#{password},#{enabled})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    public void createUser(User user);

    @Insert("insert into authorities(username,authority) values(#{username},#{authority})")
    public void createUserAuthority(User user);

}
