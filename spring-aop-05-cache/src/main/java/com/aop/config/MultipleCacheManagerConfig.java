package com.aop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


@Configuration
public class  MultipleCacheManagerConfig {
    // TODO 在一个配置类中如何引用另一个配置类中定义的bean（它们同为容器中的bean）
    //  将@Bean方法定义为static
    //  但是，像返回值是EhCacheManagerFactoryBean这样的工厂方法，你怎么引用它？
    //

    // 使用多个缓存管理器
    // 这样注入会报错
    // @Autowired
    // EhCacheConfig ehCacheConfig;

    // @Autowired
    // RedisCacheManager redisCacheManager;

    @Bean
    @Primary
    public CacheManager cacheManager() {
        CompositeCacheManager cacheManager = new CompositeCacheManager();
        List<CacheManager> managers = new ArrayList<CacheManager>();

        //CacheManagerBuilder
        //managers.add();

        managers.add(RedisCacheConfig.cacheManager(RedisCacheConfig.redisConnectionFactory()));
        cacheManager.setCacheManagers(managers);
        return cacheManager;
    }


    //public EhCacheCacheManager ehCacheCacheManager() {
    //    EhCacheCacheManager manager = new EhCacheCacheManager();
    //    EhCacheManagerFactoryBean cache = new EhCacheManagerFactoryBean();
    //    ClassPathResource resource = new ClassPathResource("ehcache/ehcache.xml");
    //    cache.setConfigLocation(resource);
    //
    //    manager.setCacheManager(cache.getObject());
    //    //manager.afterPropertiesSet();
    //    return manager;
    //}

    //// redis缓存
    //private RedisCacheManager redisCacheManager() {
    //    JedisConnectionFactory factory = new JedisConnectionFactory();
    //
    //    //初始化一个RedisCacheWriter
    //    RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(factory);
    //    //设置CacheManager的值序列化方式为json序列化
    //    RedisSerializer<Object> jsonSerializer = new GenericJackson2JsonRedisSerializer();
    //    RedisSerializationContext.SerializationPair<Object> pair = RedisSerializationContext.SerializationPair
    //            .fromSerializer(jsonSerializer);
    //    RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
    //            .serializeValuesWith(pair);
    //    //设置默认超过期时间是30秒
    //    defaultCacheConfig.entryTtl(Duration.ofSeconds(30));
    //    //初始化RedisCacheManager
    //    return new RedisCacheManager(redisCacheWriter, defaultCacheConfig);
    //}

}
