package com.springboot.myblog.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;


@ConfigurationProperties(prefix = "blog")
@Getter
@Setter
public class BlogProperties {
    private String title;
    private Banner banner;
    @Getter
    @Setter
    static class Banner {
        private String title;
        private String content;
    }
}
