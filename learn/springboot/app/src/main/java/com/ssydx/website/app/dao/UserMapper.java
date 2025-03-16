package com.ssydx.website.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ssydx.website.app.domain.Clazz;
import com.ssydx.website.app.domain.User;

@Mapper
public interface UserMapper {
    @Select("select * from user_info")
    @Results(value = {
        @Result(id = true, property = "userId",column = "user_id"),
        @Result(property = "userName",column = "user_name"),
        @Result(property = "userPwd",column = "user_pwd"),
        @Result(property = "userRegisterDate",column = "user_register_date"),
        @Result(property = "userLastLoginDate",column = "user_last_login_date"),
        @Result(property = "userLoginCount",column = "user_login_count"),
        @Result(property = "clazz", column = "clazz_id", javaType = Clazz.class, one = @One(select = "com.ssydx.website.app.dao.ClazzMapper.findById"))
    },id = "mymap")
    List<User> findAll();

    @Insert("insert into user_info(user_name,user_pwd,user_register_date,user_last_login_date,user_login_count,clazz_id) values(#{userName},#{userPwd},#{userRegisterDate},#{userLastLoginDate},#{userLoginCount},#{clazz.clazz_id})")
    @Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "user_id")
    int save(User user);

    @Delete("delete from user_info where user_id = #{userId}")
    int remove(Long userId);

    @Update("update user_info set user_name = #{userName},user_pwd = #{userPwd},user_register_date = #{userRegisterDate},user_last_login_date = #{userLastLoginDate},user_login_count = #{userLoginCount},clazz_id = #{clazz.clazz_id} where user_id = #{userId}")
    int update(User user);

    @Select("select * from user_info where user_id = #{userId}")
    @ResultMap("mymap")
    User find(Long userId);

    @Select("select * from user_info where clazz_id = #{clazz_id}")
    @Results({
        @Result(id = true, property = "userId",column = "user_id"),
        @Result(property = "userName",column = "user_name"),
        @Result(property = "userPwd",column = "user_pwd"),
        @Result(property = "userRegisterDate",column = "user_register_date"),
        @Result(property = "userLastLoginDate",column = "user_last_login_date"),
        @Result(property = "userLoginCount",column = "user_login_count")
    })
    List<User> findByClazzId(Integer clazz_id);

    List<User> findAll1();
    int save1(User user);
    int remove1(Long userId);
    int update1(User user);
    User find1(Long userId);
}
