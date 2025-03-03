package com.springboot.myblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

import com.springboot.myblog.config.BlogProperties;
import com.springboot.myblog.config.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({BlogProperties.class,FileStorageProperties.class})
@ServletComponentScan(basePackages = {"com.springboot.myblog.filter"})
public class MyblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyblogApplication.class, args);
	}

}
