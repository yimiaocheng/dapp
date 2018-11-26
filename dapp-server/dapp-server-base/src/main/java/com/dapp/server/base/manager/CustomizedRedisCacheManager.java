package com.dapp.server.base.manager;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.cache.Cache;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;

import java.util.HashMap;
import java.util.Map;

/**
 * 重写redis缓存管理器
 * 重写 RedisCacheManager createCache 方法
 * 在缓存名字上添加过期时间表达式 如:cachename#60*60
 */
public class CustomizedRedisCacheManager extends RedisCacheManager {
    private static final Logger logger = LoggerFactory.getLogger(CustomizedRedisCacheManager.class);

    private static final String SEPARATOR = "#";

    @Autowired
    DefaultListableBeanFactory beanFactory;

    public CustomizedRedisCacheManager(RedisCacheWriter cacheWriter,
                                       RedisCacheConfiguration defaultCacheConfiguration) {
        super(cacheWriter, defaultCacheConfiguration);
    }

    public CustomizedRedisCacheManager(RedisCacheWriter cacheWriter,
                                       RedisCacheConfiguration defaultCacheConfiguration,
                                       String... initialCacheNames) {
        super(cacheWriter, defaultCacheConfiguration, initialCacheNames);
    }

    public CustomizedRedisCacheManager(RedisCacheWriter cacheWriter,
                                       RedisCacheConfiguration defaultCacheConfiguration,
                                       boolean allowInFlightCacheCreation, String... initialCacheNames) {
        super(cacheWriter, defaultCacheConfiguration, allowInFlightCacheCreation, initialCacheNames);
    }

    public CustomizedRedisCacheManager(RedisCacheWriter cacheWriter,
                                       RedisCacheConfiguration defaultCacheConfiguration,
                                       Map<String, RedisCacheConfiguration> initialCacheConfigurations) {
        super(cacheWriter, defaultCacheConfiguration, initialCacheConfigurations);
    }

    public CustomizedRedisCacheManager(RedisCacheWriter cacheWriter, RedisCacheConfiguration defaultCacheConfiguration,
                                       Map<String, RedisCacheConfiguration> initialCacheConfigurations,
                                       boolean allowInFlightCacheCreation) {
        super(cacheWriter, defaultCacheConfiguration, initialCacheConfigurations, allowInFlightCacheCreation);
    }


   /* @Override
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
    }*/


}
