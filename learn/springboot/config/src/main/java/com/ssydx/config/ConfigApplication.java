package com.ssydx.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.ssydx.config.config.Property;

@SpringBootApplication(scanBasePackages = { "com.ssydx.config","org.ssydx.config" })
@ImportResource("classpath:beans.xml")
@Import(cn.ssydx.config.MyConfig.class)
@EnableConfigurationProperties(Property.class)
// @ConfigurationPropertiesScan
public class ConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigApplication.class, args);
	}

}
