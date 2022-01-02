package com.aop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerRequestService {
    Logger logger = LoggerFactory.getLogger(getClass());

    private CustomerRequestDetails customerRequestDetails;

    public CustomerRequestService() {
        logger.info("CustomerRequestService 实例化...");
    }


    public void submitRequest() {
        // 从spring容器中获取指定名称的bean
        CustomerRequestDetails details = (CustomerRequestDetails) getMyBean("customerRequestDetails");

    }
    // 被覆盖的方法
    // 覆盖的方法：由spring的MethodReplacer接口提供
    // 而 <method-replace>元素则需要配置以上两部分信息
    public Object getMyBean(String beanName){
        return null;
    }


}
