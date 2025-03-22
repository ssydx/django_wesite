package com.ssydx.website.app.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssydx.website.app.domain.MiaoshaOrder;
import com.ssydx.website.app.domain.MiaoshaProduct;
import com.ssydx.website.app.service.MiaoshaService;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MiaoshaReceiver {
	private	final MiaoshaService miaoshaService;
	private	final ObjectMapper objectMapper;

	public MiaoshaReceiver(MiaoshaService miaoshaService, ObjectMapper objectMapper) {
		this.miaoshaService = miaoshaService;
        this.objectMapper = objectMapper;
	}

	@RabbitListener(queues = RabbitMQConfig.MIAOSHA_QUEUE)
	public void receiveMessage(String message) throws JsonProcessingException {
		MiaoshaMessage miaoshaMessage = objectMapper.readValue(message, MiaoshaMessage.class);
		// 判断是否还有库存
		MiaoshaProduct miaoshaProduct = miaoshaService.getProductById(miaoshaMessage.getProductId());
		int stock = miaoshaProduct.getMiaoshaproduct_stocknum();
		if (stock <= 0) {
			return;
		}
		// 判断是否订单已存在
		MiaoshaOrder miaoshaOrder = miaoshaService.getMiaoshaOrderByUserIdAndItemId(miaoshaMessage.getUserId(), miaoshaMessage.getProductId());
		if (miaoshaOrder != null) {
			return;
		}
		// 执行秒杀
		miaoshaService.miaosha(miaoshaMessage.getUserId(), miaoshaProduct);
	}

	@RabbitListener(queues = RabbitMQConfig.MIAOSHA_QUEUE_BARK)
	public void receiveMessage_bark(String message) throws JsonProcessingException {
		System.out.println("主交换机宕机，启用备用交换机");
		MiaoshaMessage miaoshaMessage = objectMapper.readValue(message, MiaoshaMessage.class);

		MiaoshaProduct miaoshaProduct = miaoshaService.getProductById(miaoshaMessage.getProductId());
		int stock = miaoshaProduct.getMiaoshaproduct_stocknum();
		if (stock <= 0) { return; }

		MiaoshaOrder miaoshaOrder = miaoshaService.getMiaoshaOrderByUserIdAndItemId(miaoshaMessage.getUserId(), miaoshaMessage.getProductId());
		if (miaoshaOrder != null) { return; }
		miaoshaService.miaosha(miaoshaMessage.getUserId(), miaoshaProduct);
	}
}
