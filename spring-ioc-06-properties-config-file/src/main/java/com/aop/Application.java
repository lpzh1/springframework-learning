package com.aop;

import com.aop.dao.MyDataSourceProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@ImportResource({"classpath:application-context.xml"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        MyDataSourceProperties bean = context.getBean(MyDataSourceProperties.class);
        System.out.println(bean);
    }
}
