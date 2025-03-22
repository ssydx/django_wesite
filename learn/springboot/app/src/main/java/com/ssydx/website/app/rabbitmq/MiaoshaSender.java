package com.ssydx.website.app.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;
 
@Component
public class MiaoshaSender {
	private final AmqpTemplate amqpTemplate;
	private final ObjectMapper objectMapper;

	public MiaoshaSender(AmqpTemplate amqpTemplate,ObjectMapper objectMapper) {
		this.amqpTemplate = amqpTemplate;
		this.objectMapper = objectMapper;
	}

	public void sendMessage(MiaoshaMessage miaoshaMessage) throws JsonProcessingException {
		amqpTemplate.convertAndSend(
			RabbitMQConfig.MIAOSHA_EXCHANGE, 
			RabbitMQConfig.MIAOSHA_ROUTINGKEY, 
			objectMapper.writeValueAsString(miaoshaMessage)
		);
	}
}
