package com.spitter;

import com.spitter.domain.Spitter;
import com.spitter.repository.SpitterRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {JdbcApplication.class})
public class JdbcApplicationTests {



    @Test
    public void test1(){
        //System.out.println(repository);
    }






}
