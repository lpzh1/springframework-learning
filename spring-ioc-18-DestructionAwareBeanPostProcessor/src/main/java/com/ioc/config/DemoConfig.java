package com.ioc.config;

import com.ioc.DestructionApplication;
import com.ioc.service.Demo2EventService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackageClasses = {DestructionApplication.class})
@Configuration
public class DemoConfig {

    @Bean(destroyMethod = "destroy")
    public Demo2EventService demo2EventService(){
        return new Demo2EventService();
    }
}
