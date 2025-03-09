package com.ssydx.redis.domain;

import java.util.concurrent.TimeUnit;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

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
@RedisHash("user")
public class User {
    @Id
    private Integer id;
    @Indexed
    private String name;
    @Indexed
    private String description;
    private int age;
    @TimeToLive(unit = TimeUnit.HOURS)
    private Long timeout;
}
