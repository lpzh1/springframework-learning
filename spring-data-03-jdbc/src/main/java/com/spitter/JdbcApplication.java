package com.spitter;

import com.spitter.domain.Spitter;
import com.spitter.repository.SpitterRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class JdbcApplication {

    // TODO 在配置类中注入，repository为null
    // @Autowired
    // SpitterRepository repository;

}
