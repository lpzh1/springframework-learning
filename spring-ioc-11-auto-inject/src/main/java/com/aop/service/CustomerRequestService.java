package com.aop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerRequestService {
    Logger logger = LoggerFactory.getLogger(getClass());

    private CustomerRequestDetails customerRequestDetails;

    public CustomerRequestService() {
        logger.info("CustomerRequestService 实例化...");
    }

    public CustomerRequestService(CustomerRequestDetails customerRequestDetails){
        logger.info("CustomerRequestService......constructor with args");
        this.customerRequestDetails = customerRequestDetails;
    }

    public void submitRequest() {
        getCustomerRequestDetails();
    }


    public CustomerRequestDetails getCustomerRequestDetails() {
        return this.customerRequestDetails;
    }

    public void setCustomerRequestDetail(CustomerRequestDetails customerRequestDetails) {
        logger.info("setCustomerRequestDetails......");
        this.customerRequestDetails = customerRequestDetails;
    }
}
