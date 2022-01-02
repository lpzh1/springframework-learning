package com.data.datatype;

import com.data.RedisTest;
import org.junit.Test;
import org.springframework.data.redis.core.ListOperations;

import java.util.List;

public class Lists extends RedisTest {

    @Test
    public void add(){
        ListOperations<String, String> list = srt.opsForList();
        list.leftPush("cart","No.1");
        list.leftPush("cart","No.1");
        list.leftPush("cart","No.2");
    }
    @Test
    public void get(){
        ListOperations<String, String> list = srt.opsForList();
        //String cart = list.leftPop("cart");
        List<String> cart = list.range("cart", 0, 1);

        System.out.println(cart);
    }
}
