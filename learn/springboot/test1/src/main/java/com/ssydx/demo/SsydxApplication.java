package com.ssydx.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// 声明该类为应用启动类
@SpringBootApplication
public class SsydxApplication {

	public static void main(String[] args) {
		// 启动器，启动指定的类
		SpringApplication.run(SsydxApplication.class, args);
	}

}
