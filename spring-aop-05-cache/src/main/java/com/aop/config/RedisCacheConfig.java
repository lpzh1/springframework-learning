package com.aop.config;

import com.aop.condition.RedisCacheCondition;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.time.Duration;

@Conditional({RedisCacheCondition.class})
@Configuration
public class RedisCacheConfig {

    // TODO 注意:不同版本的spring-data-redis中的 RedisCacheManager的构造函数参数有所变化
    // 参考: https://www.jianshu.com/p/20366ecf12ce?utm_source=oschina-app

    // springboot 1.x 版本的 RedisCacheManager的配置
    //@Bean("redisCacheManager")
    //public CacheManager cacheManager(RedisTemplate template){
    //    return new RedisCacheManager(template);
    //}
    //
    //@Bean
    //public RedisTemplate<String,String> template(JedisConnectionFactory redisCF){
    //    RedisTemplate<String, String> template = new RedisTemplate<String, String>();
    //    template.setConnectionFactory(redisCF);
    //    template.afterPropertiesSet();
    //    return template;
    //}

    // redis连接工厂
    @Bean("redisConnectionFactory")
    public static JedisConnectionFactory redisConnectionFactory(){
        JedisConnectionFactory factory = new JedisConnectionFactory();
        //factory.setHostName("");
        factory.afterPropertiesSet();
        return factory;
    }

    //下面是 springboot 2.x 版本中 RedisCacheManager的配置
    /**
     * 缓存管理器
     */
    @Bean("redisCacheManager")
    //@Primary
    public static CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        //初始化一个RedisCacheWriter
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory);
        //设置CacheManager的值序列化方式为json序列化
        RedisSerializer<Object> jsonSerializer = new GenericJackson2JsonRedisSerializer();
        RedisSerializationContext.SerializationPair<Object> pair = RedisSerializationContext.SerializationPair
                .fromSerializer(jsonSerializer);
        RedisCacheConfiguration defaultCacheConfig=RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(pair);
        //设置默认超过期时间是30秒
        defaultCacheConfig.entryTtl(Duration.ofSeconds(30));
        //初始化RedisCacheManager
        return new RedisCacheManager(redisCacheWriter, defaultCacheConfig);
    }

}
