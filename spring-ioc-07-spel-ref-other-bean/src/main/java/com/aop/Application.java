package com.aop;

import com.aop.spel.ApplicationManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//@ImportResource({"classpath:application-context.xml"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        ApplicationManager applicationManager = context.getBean("applicationManager", ApplicationManager.class);
        System.out.println(applicationManager);
    }
}
