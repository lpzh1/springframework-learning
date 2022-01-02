package com.aop.config;

import net.sf.ehcache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class EhCacheConfig {

    // TODO 多个缓存管理器无法共存
    //  多个缓存管理器请使用 CompositeCacheManager

    // 生成Ehcache的cacheManager
    @Bean("ehCacheManager")
    public static EhCacheManagerFactoryBean ehcache(){
        EhCacheManagerFactoryBean cache = new EhCacheManagerFactoryBean();
        ClassPathResource resource = new ClassPathResource("ehcache/ehcache.xml");
        cache.setConfigLocation(resource);

        return cache;
    }
    // 将Ehcache的cacheManager注入到spring的cacheManager
    @Bean("springCacheManager")
    public static EhCacheCacheManager cacheManager(CacheManager cm){
        return new EhCacheCacheManager(cm);
    }
}
