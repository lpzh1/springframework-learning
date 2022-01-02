package com.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource(value = {"classpath:application-context.xml"})
@SpringBootApplication
public class DependOnApplication {

    public static void main(String[] args) {
        SpringApplication.run(DependOnApplication.class);
    }

    //@Bean()
    //public EventSenderSelectorService eventSenderSelectorService() throws IOException {
    //    return new EventSenderSelectorService("");
    //}
}
