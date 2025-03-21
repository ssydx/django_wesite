package com.ssydx.website.app.rabbitmq;

import com.ssydx.website.app.domain.User;

public class MiaoshaMessage
{
	private User user;
	private long itemId;

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public long getItemId()
	{
		return itemId;
	}

	public void setItemId(long itemId)
	{
		this.itemId = itemId;
	}
}
