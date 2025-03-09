package com.ssydx.lettuce;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Map;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.SetArgs;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

public class SyncTest {
	static RedisClient redisClient;
	static StatefulRedisConnection<String,String> connection;
	public static void init() {
		RedisURI redisURI = RedisURI.builder()
			.withHost("172.20.241.159")
			.withDatabase(0)
			.withPort(6379)
			.withTimeout(Duration.of(30, ChronoUnit.SECONDS))
			.build();
		redisClient = RedisClient.create(redisURI);
		connection = redisClient.connect();
	}
    public static void closeResource() {
        connection.close();
        redisClient.shutdown();
    }
    public static void main(String[] args) {
        init();
        RedisCommands<String,String> redisCommands = connection.sync();
        SetArgs setArgs = SetArgs.Builder.nx().ex(2000);
        System.out.println(redisCommands.ping());
        String result1 = redisCommands.set("name", "ssydx", setArgs);
        System.out.println(result1);
        Long result2 = redisCommands.hset("user", Map.of("name","ssydx","age","25"));
        System.out.println(result2);
        String result3 = redisCommands.get("name");
        System.out.println(result3);
        System.out.println(redisCommands.hget("user", "age"));
        closeResource();
    }
}
