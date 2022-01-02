package com.data.redis;

import com.data.config.RedisConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {RedisConfig.class})
public class RedisConnectionTest {
    @Autowired
    RedisConnectionFactory factory;

    @Test
    public void save(){
        RedisConnection conn = factory.getConnection();
        conn.set("greeting".getBytes(),"How are you".getBytes());
    }
    @Test
    public void get(){
        RedisConnection conn = factory.getConnection();
        byte[] bytes = conn.get("greeting".getBytes());
        System.out.println(new String(bytes));
    }
}
