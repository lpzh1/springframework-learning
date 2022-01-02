package com.data.config;

import com.data.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisConnectionFactory redisCF(){
        RedisStandaloneConfiguration conf = new RedisStandaloneConfiguration();
        conf.setHostName("localhost");
        conf.setDatabase(0);
        conf.setPort(6379);

        JedisConnectionFactory factory = new JedisConnectionFactory(conf);
        return factory;
    }

    @Bean
    public RedisTemplate redisTemplate(){
        RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisCF());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        return redisTemplate;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(){
        StringRedisTemplate srt = new StringRedisTemplate();
        //new StringRedis
        srt.setConnectionFactory(redisCF());
        return srt;
    }
}
