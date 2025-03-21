package com.ssydx.website.app.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.ssydx.website.app.domain.Order;

@Mapper
public interface OrderMapper {
	@Insert("insert into order_info(user_id, product_id, product_name, order_num, order_price, order_channel, order_status, create_date) values(#{user_id}, #{product_id}, #{product_name}, #{order_num}, #{order_price}, #{order_channel}, #{order_status}, #{create_date})")
	@Options(useGeneratedKeys = true, keyProperty = "order_id")
	long save(Order order);

	@Select("select order_id, user_id, product_id, product_name, order_num, order_price, order_channel, order_status, create_date, pay_date from order_info where order_id = #{orderId} and user_id = #{userId}")
	Order findByIdAndOwnerId(long orderId, long userId);
}
