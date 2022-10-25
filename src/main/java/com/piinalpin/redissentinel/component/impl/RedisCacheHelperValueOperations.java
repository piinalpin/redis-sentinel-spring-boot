package com.piinalpin.redissentinel.component.impl;

import com.piinalpin.redissentinel.component.RedisCacheHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class RedisCacheHelperValueOperations implements RedisCacheHelper {

    public static final String BEAN_NAME = "redisCacheHelperValueOperations";
    private static final String SEPARATOR_CACHE = ":";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void put(String cacheName, Object key, Object value, long ttl) {
        redisTemplate.opsForValue().set(constructKey(cacheName, key), value, ttl, TimeUnit.SECONDS);
    }

    @Override
    public Object get(String cacheName, Object key) {
        return redisTemplate.opsForValue().get(constructKey(cacheName, key));
    }

    @Override
    public void remove(String cacheName, Object key) {
        redisTemplate.opsForValue().getOperations().delete(constructKey(cacheName, key));
    }

    private String constructKey(String cacheName, Object key) {
        return cacheName + SEPARATOR_CACHE + key;
    }

}
