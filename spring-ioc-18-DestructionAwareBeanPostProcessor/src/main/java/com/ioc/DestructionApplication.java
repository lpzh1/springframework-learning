package com.ioc;

import com.ioc.config.DemoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootApplication
public class DestructionApplication {

    //public static void main(String[] args) {
    //    SpringApplication.run(DestructionApplication.class);
    //}

    public static void main(String[] args) {
        //new ClassPathXmlApplicationContext("beans.xml");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        //DemoEvent event = context.getBean(DemoEvent.class);
        //System.out.println(event);
        context.close();

    }
}
