package com.ssydx.config.config;

import java.util.List;

import org.hibernate.validator.constraints.Range;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
// @Setter
@ConfigurationProperties(prefix = "com.ssydx.config", ignoreUnknownFields = false)
// @Component
@Validated
public class Property {
    private boolean enabled;
    @NotNull
    private String name;
    @Range(min = 18,max = 60,message = "必须在18-60")
    private int age;
    private List<String> items;
    @ConstructorBinding
    public Property(boolean enabled,String name,int age,List<String> items) {
        this.enabled = enabled;
        this.name = name;
        this.age = age;
        this.items = items;
    }
}
