package com.ssydx.shizhan.redis;

public interface KeyPrefix {
    int expireSeconds();
    String getPrefix();
}
