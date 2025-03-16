package com.ssydx.shizhan.redis;

public class ItemKey extends AbstractPrefix {
	public ItemKey(int expireSeconds, String prefix) {
		super(expireSeconds, prefix);
	}
	public static ItemKey itemList = new ItemKey(120, "list");
	public static ItemKey miaoshaItemStock = new ItemKey(0, "stock");
}
