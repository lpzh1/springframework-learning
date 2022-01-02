package com.aop.config;

import com.aop.anno.UserAnno;
import com.aop.condition.UserCondition;
import com.aop.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @UserAnno
    @Bean
    @Conditional({UserCondition.class})
    public User user(){
        return new User("张三");
    }

}
