package com.ssydx.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ssydx.rabbitmq.util.MyConsts;

@Configuration
public class FanoutConfig {
    @Bean
    public Queue fanout1() { return new Queue(MyConsts.QUEUE_FANOUT_Q1); }
    @Bean
    public Queue fanout2() { return new Queue(MyConsts.QUEUE_FANOUT_Q2); }
    @Bean
    public Queue fanout3() { return new Queue(MyConsts.QUEUE_FANOUT_Q3); }
    @Bean
    public Queue fanout4() { return new Queue(MyConsts.QUEUE_FANOUT_Q4); }
    @Bean
    public FanoutExchange setFanoutExchange() { return new FanoutExchange(MyConsts.EXCHANGE); }
    @Bean
    public Binding bindQ1() { return BindingBuilder.bind(fanout1()).to(setFanoutExchange()); }
    @Bean
    public Binding bindQ2() { return BindingBuilder.bind(fanout2()).to(setFanoutExchange()); }
    @Bean
    public Binding bindQ3() { return BindingBuilder.bind(fanout3()).to(setFanoutExchange()); }
    @Bean
    public Binding bindQ4() { return BindingBuilder.bind(fanout4()).to(setFanoutExchange()); }
}
