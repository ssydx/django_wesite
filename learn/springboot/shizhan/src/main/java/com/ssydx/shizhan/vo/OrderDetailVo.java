package com.ssydx.shizhan.vo;

import com.ssydx.shizhan.domain.MiaoshaItem;
import com.ssydx.shizhan.domain.Order;
import com.ssydx.shizhan.domain.User;

public class OrderDetailVo
{
	private MiaoshaItem miaoshaItem;
	private Order order;
	private User user;

	public MiaoshaItem getMiaoshaItem()
	{
		return miaoshaItem;
	}

	public void setMiaoshaItem(MiaoshaItem miaoshaItem)
	{
		this.miaoshaItem = miaoshaItem;
	}

	public Order getOrder()
	{
		return order;
	}

	public void setOrder(Order order)
	{
		this.order = order;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	@Override
	public String toString()
	{
		return "OrderDetailVo{" +
				"miaoshaItem=" + miaoshaItem +
				", order=" + order +
				", user=" + user +
				'}';
	}
}
