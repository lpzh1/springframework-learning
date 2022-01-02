package com.ioc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CustomerRequestDetails {


    Logger logger = LoggerFactory.getLogger(getClass());

    public CustomerRequestDetails(){
        logger.info("CustomerRequestDetails 实例化...");
    }
}
