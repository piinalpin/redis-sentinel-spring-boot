package com.piinalpin.redissentinel.component.impl;

import com.piinalpin.redissentinel.component.RedisCacheHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component(value = RedisCacheHelperHashOperations.BEAN_NAME)
public class RedisCacheHelperHashOperations implements RedisCacheHelper {

    public static final String BEAN_NAME = "redisCacheHelperHashOperations";

    @Autowired
    public RedisTemplate<String, Object> redisTemplate;

    @Override
    public void put(String cacheName, Object key, Object value, long ttl) {
        redisTemplate.opsForHash().put(cacheName, key, value);
    }

    @Override
    public Object get(String cacheName, Object key) {
        return redisTemplate.opsForHash().get(cacheName, key);
    }

    @Override
    public void remove(String cacheName, Object key) {
        redisTemplate.opsForHash().getOperations().delete(cacheName + key);
    }
}
