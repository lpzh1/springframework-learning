package com.data.redis;

import com.data.config.RedisConfig;
import com.data.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {RedisConfig.class})
public class StringRedisTemplateTest {

    @Autowired
    StringRedisTemplate srt;

    @Test
    public void save(){
        ValueOperations value = srt.opsForValue();
        value.set("user","{\"id\":1,\"name\":\"zhang\"}");
    }

    @Test
    public void get(){
        ValueOperations value = srt.opsForValue();
        Object user = value.get("user");
        System.out.println(user);
    }
}
