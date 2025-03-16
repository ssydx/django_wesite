package com.ssydx.shizhan.redis;

public class OrderKey extends AbstractPrefix {
	public OrderKey(String prefix) {
		super(prefix);
	}
	public static OrderKey miaoshaOrderByUserIdAndItemId = new OrderKey("mOrderUserItem");
}
