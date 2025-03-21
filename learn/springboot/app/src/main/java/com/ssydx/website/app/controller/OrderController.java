package com.ssydx.website.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssydx.website.app.config.AccessLimit;
import com.ssydx.website.app.domain.Order;
import com.ssydx.website.app.domain.User;
import com.ssydx.website.app.service.MiaoshaService;

/**
 * Description:<br>
 * 网站: <a href="http://www.crazyit.org">疯狂Java联盟</a><br>
 * Copyright (C), 2001-2022, Yeeku.H.Lee<br>
 * This program is protected by copyright laws.<br>
 * Program Name:<br>
 * Date:<br>
 *
 * @author Yeeku.H.Lee kongyeeku@163.com 公众号: fkbooks<br>
 * @version 1.0
 */
@Controller
@RequestMapping("/page")
public class OrderController
{
	private final MiaoshaService miaoshaService;
	public OrderController(MiaoshaService miaoshaService)
	{
		this.miaoshaService = miaoshaService;
	}

	@GetMapping("/detail")
	@ResponseBody
	@AccessLimit // 限制该方法必须登录才能访问
	public Order detail(User user, @RequestParam("orderId") long orderId)
	{
		// 根据订单ID和用户ID获取订单
		Order order = miaoshaService.getOrderByIdAndOwnerId(orderId, user.getUserId());
		// 如果订单为null，表明还没有订单
		if (order == null) {
			return null;
		}
		// 返回OrderDetailVo
		return order;
	}
}

