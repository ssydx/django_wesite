package com.ssydx.website.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ssydx.website.app.domain.Clazz;

@Mapper
public interface ClazzMapper {
    @Select("select * from clazz_info where clazz_id = #{clazz_id}")
    Clazz findById(Integer clazz_id);
    @Select("select * from clazz_info")
    @Results({
        @Result(property = "users",column = "clazz_id",javaType = List.class, many = @Many(select = "com.ssydx.website.app.dao.UserMapper.findByClazzId"))
    })
    List<Clazz> findAllUsers();
}
