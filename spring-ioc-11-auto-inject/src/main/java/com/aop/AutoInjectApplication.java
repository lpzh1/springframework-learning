package com.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

// 自动装配
@ImportResource({"classpath:application-context.xml"})
@SpringBootApplication
public class AutoInjectApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AutoInjectApplication.class);
        //CustomerRequestService service = context.getBean(CustomerRequestService.class);
        //
        //service.submitRequest();
        //service.submitRequest();
    }
}
