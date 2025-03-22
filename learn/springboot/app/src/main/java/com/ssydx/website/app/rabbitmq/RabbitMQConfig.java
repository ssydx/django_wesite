package com.ssydx.website.app.rabbitmq;

import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	public static final String MIAOSHA_EXCHANGE = "miaosha";
	public static final String MIAOSHA_QUEUE = "miaosha";
	public static final String MIAOSHA_QUEUE_BARK = "miaosha_bark";
	public static final String MIAOSHA_ROUTINGKEY = "miaosha";
	@Bean
	public DirectExchange directExchange() { return new DirectExchange(MIAOSHA_EXCHANGE, true, false, Map.of()); }
	@Bean
	public Queue queue() { return new Queue(MIAOSHA_QUEUE, true, false, false, Map.of("alternate-exchange",MIAOSHA_QUEUE_BARK)); }
	@Bean
	public Binding binding() { return BindingBuilder.bind(queue()).to(directExchange()).with(MIAOSHA_ROUTINGKEY); }

}
