package com.piinalpin.redissentinel.service;

import com.piinalpin.redissentinel.component.RedisCacheHelper;
import com.piinalpin.redissentinel.component.impl.RedisCacheHelperHashOperations;
import com.piinalpin.redissentinel.component.impl.RedisCacheHelperValueOperations;
import com.piinalpin.redissentinel.dto.DataCacheDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
public class DemoService {

    @Autowired
    @Qualifier(RedisCacheHelperHashOperations.BEAN_NAME)
    private RedisCacheHelper cacheHelperHash;

    @Autowired
    @Qualifier(RedisCacheHelperValueOperations.BEAN_NAME)
    private RedisCacheHelper cacheHelperValue;

    @Value("${spring.cache.redis.time-to-live:600}")
    private Integer defaultTtl;

    private final static String DEMO = "DEMO";

    private String generateKey() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public Map<String, Object> putHash(DataCacheDto request) {
        String key = this.generateKey();
        try {
            log.info("Put data [{}] to cache by hash operations", request);
            cacheHelperHash.put(DEMO, key, request, defaultTtl);
        } catch (Exception e) {
            log.error("Got exception when put cache by hash operations", e);
            throw e;
        }
        return Map.of("key", key);
    }

    public DataCacheDto getFromHash(String key) {
        DataCacheDto cache;
        try {
            log.info("Get data from cache by hash operation. Key :: [{}]", key);
            cache = (DataCacheDto) cacheHelperHash.get(DEMO, key);
            log.info("Data cache :: {}", cache);
        } catch (Exception e) {
            log.error("Got exception when get cache by hash operations", e);
            throw e;
        }
        return cache;
    }

    public Map<String, Object> putValue(DataCacheDto request) {
        String key = this.generateKey();
        try {
            log.info("Put data [{}] to cache by value operations", request);
            cacheHelperValue.put(DEMO, key, request, defaultTtl);
        } catch (Exception e) {
            log.error("Got exception when put cache by value operations", e);
            throw e;
        }
        return Map.of("key", key);
    }

    public DataCacheDto getFromValue(String key) {
        DataCacheDto cache;
        try {
            log.info("Get data from cache by value operation. Key :: [{}]", key);
            cache = (DataCacheDto) cacheHelperValue.get(DEMO, key);
            log.info("Data cache :: {}", cache);
        } catch (Exception e) {
            log.error("Got exception when get cache by value operations", e);
            throw e;
        }
        return cache;
    }

}
