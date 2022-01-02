package com.aop;

import com.aop.service.CustomerRequestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@ImportResource({"classpath:application-context.xml"})
@SpringBootApplication
public class ReplaceMethodApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ReplaceMethodApplication.class);
        CustomerRequestService service = context.getBean(CustomerRequestService.class);
        // 使用<replace-method>
        service.submitRequest();
        service.submitRequest();
    }
}
