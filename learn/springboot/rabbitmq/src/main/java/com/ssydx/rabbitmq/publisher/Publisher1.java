package com.ssydx.rabbitmq.publisher;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ssydx.rabbitmq.util.MyConsts;

@Component
public class Publisher1 implements CommandLineRunner {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void run(String... args) throws Exception {
        // 创建消息属性
        MessageProperties messageProperties = new MessageProperties();
        // 设置内容类型
        messageProperties.setContentType("text/plain");

        // 创建消息体
        byte[] body = "123".getBytes();

        // 创建Spring AMQP Message对象
        Message message = new Message(body, messageProperties);

        // 发送消息到指定的交换机，并指定路由键为null（如果不需要特定的路由键）
        rabbitTemplate.send(MyConsts.EXCHANGE, null, message);
        System.out.println("==========");
    }
}