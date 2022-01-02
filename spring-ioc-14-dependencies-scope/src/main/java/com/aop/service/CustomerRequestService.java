package com.aop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class CustomerRequestService
    implements ApplicationContextAware
{
    Logger logger = LoggerFactory.getLogger(getClass());

   private CustomerRequestDetails customerRequestDetails;

    public CustomerRequestService(){
        logger.info("CustomerRequestService 实例化...");
    }


    public void submitRequest(){

    }

    public CustomerRequestDetails getCustomerRequestDetails() {
        //return customerRequestDetails;
        // 借助 ApplicationContextAware 注入的ApplicationContext
        // 每次都拿到全新的 customerRequestDetails 实例
        return this.applicationContext.getBean(CustomerRequestDetails.class);
    }

    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // 声明周期方法，也是只会调用一次
        // 调用时期：在bean被创建之后，并且在bean初始化之前
        logger.info("CustomerRequestService－＞setApplicationContext ");
        this.applicationContext = applicationContext;
    }
}
