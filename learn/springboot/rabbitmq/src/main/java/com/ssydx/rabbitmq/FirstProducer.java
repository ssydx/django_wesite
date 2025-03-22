package com.ssydx.rabbitmq;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class FirstProducer {
    private static final String HOST_NAME = "localhost";
    private static final int HOST_PORT = 5672;
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "123456";
    private static final String VIRTUAL_HOST = "mirror";
    private static final String QUEUE_NAME = "test2";
    private static final String EXCHANGE_NAME = "exchange1";
    private static final String ROUTING_KEY = "key1";
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST_NAME);
        factory.setPort(HOST_PORT);
        factory.setUsername(USER_NAME);
        factory.setPassword(PASSWORD);
        factory.setVirtualHost(VIRTUAL_HOST);
        Channel channel = null;
        Connection connection = null;
        try {
            connection = factory.newConnection();
            channel = connection.createChannel();
            Map<String,Object> params = new HashMap<>();
            channel.exchangeDeclare(EXCHANGE_NAME,BuiltinExchangeType.DIRECT,true,false,false,Map.of("alternate-exchange","xxxx"));
            channel.queueDeclare(QUEUE_NAME, true, false, false, params);
            channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, MessageProperties.PERSISTENT_TEXT_PLAIN, "1".getBytes());
            channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, MessageProperties.PERSISTENT_TEXT_PLAIN, "2".getBytes());
            channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, MessageProperties.PERSISTENT_TEXT_PLAIN, "3".getBytes());
            channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, MessageProperties.PERSISTENT_TEXT_PLAIN, "4".getBytes());
            channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, MessageProperties.PERSISTENT_TEXT_PLAIN, "5".getBytes());
            channel.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
