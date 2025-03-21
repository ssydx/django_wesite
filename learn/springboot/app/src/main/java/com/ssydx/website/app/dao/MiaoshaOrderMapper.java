package com.ssydx.website.app.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ssydx.website.app.domain.MiaoshaOrder;

import io.lettuce.core.dynamic.annotation.Param;

@Mapper
public interface MiaoshaOrderMapper {
	@Select("select miaoshaorder_id, user_id, order_id, product_id from miaoshaorder_info where user_id=#{userId} and product_id=#{itemId}")
	MiaoshaOrder findByUserIdItemId(@Param("userId") long userId, @Param("itemId") long itemId);
	@Insert("insert into miaoshaorder_info(user_id, product_id, order_id) values(#{user_id}, #{product_id}, #{order_id})")
	int save(MiaoshaOrder miaoshaOrder);
}
