package com.ssydx.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.ssydx.rabbitmq.util.MyConsts;

@Component
public class receiver1 {
    @RabbitListener(queues = MyConsts.QUEUE_FANOUT_Q1)
    public void receiveFromQ1(String message) {
        System.out.println("Received from Q1: " + message);
    }

    @RabbitListener(queues = MyConsts.QUEUE_FANOUT_Q2)
    public void receiveFromQ2(String message) {
        System.out.println("Received from Q2: " + message);
    }
}
