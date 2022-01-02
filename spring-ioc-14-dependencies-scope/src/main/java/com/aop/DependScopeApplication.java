package com.aop;

import com.aop.service.CustomerRequestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@ImportResource({"classpath:application-context.xml"})
@SpringBootApplication
public class DependScopeApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DependScopeApplication.class);
        CustomerRequestService service = context.getBean(CustomerRequestService.class);
        // 连续调用两次，只实例化一次CustomerRequestDetails
        // 虽然 CustomerRequestDetails在spring中是 prototype
        service.getCustomerRequestDetails();
        service.getCustomerRequestDetails();
    }
}
