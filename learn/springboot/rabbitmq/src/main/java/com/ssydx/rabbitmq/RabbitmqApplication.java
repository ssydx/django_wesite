package com.ssydx.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(RabbitmqApplication.class);
		// application.addListeners(new MyListener());
		application.run(args);
	}

}
