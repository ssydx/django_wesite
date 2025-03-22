package com.ssydx.rabbitmq;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class FirstConsumer1 {
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
            channel.queueDeclare(QUEUE_NAME, true, false, false, params);
            channel.basicQos(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("===============");
                String routingKey = envelope.getRoutingKey();
                System.out.println("=============>routingKey:" + routingKey);
                String contentType = properties.getContentType();
                System.out.println("=============>contentType:" + contentType);
                long deliveryTag = envelope.getDeliveryTag();
                System.out.println("=============>deliveryTag:" + deliveryTag);
                System.out.println("content:" + new String(body, "UTF-8"));
                getChannel().basicAck(deliveryTag, true);
            }
        };
        try {
            channel.basicConsume(QUEUE_NAME, false, consumer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
