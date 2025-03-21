package com.ssydx.website.app.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

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
@Component
public class MiaoshaSender
{
	private final AmqpTemplate amqpTemplate;
	private final ObjectMapper objectMapper;

	public MiaoshaSender(AmqpTemplate amqpTemplate,ObjectMapper objectMapper) {
		this.amqpTemplate = amqpTemplate;
		this.objectMapper = objectMapper;
	}

	public void sendMiaoshaMessage(MiaoshaMessage miaoshaMessage) throws  JsonProcessingException {
		// 将MiaoshaMessage转换成字符串
		String msg = objectMapper.writeValueAsString(miaoshaMessage);
		// 发送消息
		amqpTemplate.convertAndSend(MQConfig.MIAOSHA_QUEUE, msg);
	}
}
