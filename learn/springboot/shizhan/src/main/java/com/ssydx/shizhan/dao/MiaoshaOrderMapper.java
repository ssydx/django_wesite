package com.ssydx.shizhan.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ssydx.shizhan.domain.MiaoshaOrder;

import io.lettuce.core.dynamic.annotation.Param;

@Mapper
public interface MiaoshaOrderMapper {
    @Select("select miaosha_order_id as id,user_id as userId,order_id as OrderId,item_id as itemId from miaosha_order where user_id = #{userId} and item_id = #{itemId}")
    MiaoshaOrder findByUserIdAndItemId(@Param("userId") long userId,@Param("itemId") long itemId);

    @Select("insert into maiosha_order(user_id,item_id,order_id) values(#{userId},#{itemId},#{orderId})")
    int save(MiaoshaOrder miaoshaOrder);
}
