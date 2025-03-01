package com.springboot.myblog.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
    private String uploadDir;
}