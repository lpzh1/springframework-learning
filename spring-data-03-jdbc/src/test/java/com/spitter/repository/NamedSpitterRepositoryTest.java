package com.spitter.repository;

import com.spitter.JdbcApplicationTests;
import com.spitter.domain.Spitter;
import com.spitter.repository.impl.NamedSpitterRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class NamedSpitterRepositoryTest extends JdbcApplicationTests {

    @Autowired
    NamedSpitterRepository repository;

    @Test
    public void addSpitter(){
        Spitter spitter = new Spitter();
        spitter.setEmail("xxx@cc.com");
        spitter.setUsername("宋晓峰");
        spitter.setPassword("123");
        spitter.setFullName("宋晓峰 宋总");
        spitter.setUpdateByEmail(false);

        repository.addSpitter(spitter);
    }

    @Test
    public void findOne(){
        Spitter one = repository.findOne(1L);
        System.out.println(one);
    }

}
