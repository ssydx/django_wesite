package com.ssydx.website.app.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssydx.website.app.domain.MiaoshaOrder;
import com.ssydx.website.app.domain.MiaoshaProduct;
import com.ssydx.website.app.domain.User;
import com.ssydx.website.app.service.MiaoshaService;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MiaoshaReceiver {
	private	final MiaoshaService miaoshaService;
	private	final ObjectMapper objectMapper;

	public MiaoshaReceiver(MiaoshaService miaoshaService,ObjectMapper objectMapper) {
		this.miaoshaService = miaoshaService;
        this.objectMapper = objectMapper;
	}

	@RabbitListener(queues = MQConfig.MIAOSHA_QUEUE)
	public void receive(String message) throws JsonProcessingException {
		// 将字符串类型的消息转换成MiaoshaMessage对象
		MiaoshaMessage miaoshaMessage = objectMapper.readValue(message, MiaoshaMessage.class);
		// 获取秒杀用户
		User user = miaoshaMessage.getUser();
		// 获取秒杀商品的ID
		long itemId = miaoshaMessage.getItemId();
		// 获取秒杀商品
		MiaoshaProduct item = miaoshaService.getProductById(itemId);
		int stock = item.getMiaoshaproduct_stocknum();
		if (stock <= 0) {
			return;
		}
		MiaoshaOrder miaoshaOrder = miaoshaService.getMiaoshaOrderByUserIdAndItemId(user.getUserId(), itemId);
		if (miaoshaOrder != null) {
			return;
		}
		miaoshaService.miaosha(user, item);
	}
}
