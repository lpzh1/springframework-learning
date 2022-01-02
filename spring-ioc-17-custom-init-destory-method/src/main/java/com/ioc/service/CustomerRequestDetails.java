package com.ioc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerRequestDetails {

    Logger logger = LoggerFactory.getLogger(getClass());

    public CustomerRequestDetails(){
        logger.info("CustomerRequestDetails 实例化...");
    }
}
