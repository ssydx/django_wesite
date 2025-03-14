package com.ssydx.shizhan.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ssydx.shizhan.domain.User;

@Mapper
public interface UserMapper {
    @Select("select user_id as id, nickname, password, salt, head,register_date as registerDate, last_login_date as lastLoginDate,login_count as loginCount from user_info where user_id = #{id}")
    User findById(long id);
    @Update("update user_info set last_login_date = #{lastLoginDate}," + "login_count = #{loginCount} where user_id = #{id}")
    void update(User user);
}
