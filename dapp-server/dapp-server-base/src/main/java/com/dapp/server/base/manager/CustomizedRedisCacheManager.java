package com.dapp.server.base.manager;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.cache.Cache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisOperations;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomizedRedisCacheManager extends RedisCacheManager {
    private static final Logger logger = LoggerFactory.getLogger(CustomizedRedisCacheManager.class);

    private static final String SEPARATOR = "#";

    @Autowired
    DefaultListableBeanFactory beanFactory;

    public CustomizedRedisCacheManager(RedisOperations redisOperations) {
        super(redisOperations);
    }

    public CustomizedRedisCacheManager(RedisOperations redisOperations, Collection<String> cacheNames) {
        super(redisOperations, cacheNames);
    }

    @Override
    public Cache getCache(String name) {
        String[] cacheParams = name.split(SEPARATOR);
        String cacheName = cacheParams[0];

        if (StringUtils.isBlank(cacheName)) {
            return null;
        }

        if (cacheParams.length > 1) {
            Map<String,Long> expiresMap=new HashMap<>();
            expiresMap.put(cacheName,Long.parseLong(cacheParams[1]));
            this.setExpires(expiresMap);
        }
        return super.getCache(cacheName);
    }


}
