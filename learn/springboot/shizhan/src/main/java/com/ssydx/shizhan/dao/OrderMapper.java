package com.ssydx.shizhan.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ssydx.shizhan.domain.Order;

@Mapper
public interface OrderMapper {
    @Insert("insert into order_info(user_id,item_id,item_name,order_num,order_price,order_channel,order_status,create_date) values(#{userId},#{itemId},#{itemName},#{orderNum},#{orderPrice},#{orderChannel},#{orderStatus},#{createDate})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    long save(Order order);

    @Select("select order_id as id,user_id as userId,item_id as itemId, item_name as itemName,order_num as orderNum,order_price as orderPrice, order_channel as orderChannel, order_status as orderStatus, create_date as createDate,pay_date as payDate from order_info where user_id = #{userId} and order_id = #{orderId} ")
    Order findByIdAndOwnerId(@Param("userId") long userId,@Param("orderId") long orderId);
}
