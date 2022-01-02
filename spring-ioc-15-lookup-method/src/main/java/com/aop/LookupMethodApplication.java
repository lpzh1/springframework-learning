package com.aop;

import com.aop.service.CustomerRequestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@ImportResource({"classpath:application-context.xml"})
@SpringBootApplication
public class LookupMethodApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(LookupMethodApplication.class);
        CustomerRequestService service = context.getBean(CustomerRequestService.class);
        // 使用<lookup-method>元素，在singleton bean中获取 prototype bean的全新实例
        service.submitRequest();
        service.submitRequest();
    }
}
