package com.aop.config;


import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.*;
import org.springframework.cache.annotation.EnableCaching;

import java.util.Arrays;
import java.util.List;

//@ImportResource({"classpath:cache-CompositeCacheManager.xml"})
@ComponentScan(basePackages = {"com.aop"})
@Configuration
@EnableCaching
public class CachingConfig {

    // 简单的缓存管理器
    //@Bean("mapCacheManager")
    //public CacheManager cacheManager(){
    //    ConcurrentMapCacheManager manager = new ConcurrentMapCacheManager();
    //    List<String> userCacheNames = Arrays.asList("user");
    //    manager.setCacheNames(userCacheNames);
    //    // new SimpleCacheManager();
    //    return manager;
    //}

    // TODO 注意: ehcache和spring都声明了一个名为 CacheManager的接口
    // 如果spring容器存在多个CacheManager接口实现的bean，会报错
    // No CacheResolver specified, and no unique bean of type CacheManager found.
}
