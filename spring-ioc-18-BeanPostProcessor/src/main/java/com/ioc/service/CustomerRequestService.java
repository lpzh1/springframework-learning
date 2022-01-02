package com.ioc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
public class CustomerRequestService{
    Logger logger = LoggerFactory.getLogger(getClass());

    private CustomerRequestDetails customerRequestDetails;

    public CustomerRequestService() {
        logger.info("CustomerRequestService 实例化...");
    }

    @Autowired // 注解的方式实现自动注入
    public void setCustomerRequestDetails(CustomerRequestDetails customerRequestDetails) {
        logger.info("setCustomerRequestDetails ...");
        this.customerRequestDetails = customerRequestDetails;
    }

    public void submitRequest() {

    }

     // 初始化方法
     // 注意: init() 方法是在 setter方法完成属性依赖注入之后调用
    //@PostConstruct
     public void init(){
       logger.info("CustomerRequestService's init() method has been invoked !");
    }

    //@Autowired
    //CommonAnnotationBeanPostProcessor postProcessor;

    //@PreDestroy
    public void destroy(){
        logger.info("CustomerRequestService's destroy() method has been invoked !");
    }



}
