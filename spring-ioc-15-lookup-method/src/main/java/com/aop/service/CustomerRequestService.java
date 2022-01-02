package com.aop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class CustomerRequestService {
    Logger logger = LoggerFactory.getLogger(getClass());

    private CustomerRequestDetails customerRequestDetails;

    public CustomerRequestService() {
        logger.info("CustomerRequestService 实例化...");
    }


    public void submitRequest() {
        getCustomerRequestDetails();
    }

    /**
     * 注意: getCustomerRequestDetails可以定义为抽象或具体都行，此处定义为抽象！
     * 它将被spring容器覆盖掉
     *
     * @return
     */
    public abstract CustomerRequestDetails getCustomerRequestDetails();


}
