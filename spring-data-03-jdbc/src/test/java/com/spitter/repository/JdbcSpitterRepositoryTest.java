package com.spitter.repository;

import com.spitter.JdbcApplicationTests;
import com.spitter.domain.Spitter;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class JdbcSpitterRepositoryTest extends JdbcApplicationTests {
    @Autowired
    SpitterRepository repository;

    @Test
    public void updateSpitter(){
        Spitter spitter = new Spitter();
        spitter.setId(1L);
        spitter.setUsername("zhangsan");
        spitter.setPassword("123");
        spitter.setEmail("AAA@12.com");
        spitter.setFullName("zhangsan niao");

        //repository.updateSpitter(spitter);
    }

    @Test
    public void getOne(){
        Spitter one = repository.findOne(2L);
        System.out.println(one);
    }

    @Test
    public void count(){
        long count = repository.count();
        System.out.println(count);
    }
}
