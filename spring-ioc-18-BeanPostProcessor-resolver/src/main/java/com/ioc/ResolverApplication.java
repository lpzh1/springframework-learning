package com.ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource({"classpath:application-context.xml"})
@SpringBootApplication
public class ResolverApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResolverApplication.class);
    }
}