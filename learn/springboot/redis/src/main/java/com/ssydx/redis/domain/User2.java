package com.ssydx.redis.domain;

import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("user2")
public class User2 {
    private Integer id;
    private String name;
    private String description;
    private int age;
    private Long timeout;
}
