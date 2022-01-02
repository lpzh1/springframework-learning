package com.aop.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerRequestDao {
    Logger logger = LoggerFactory.getLogger(getClass());

    public CustomerRequestDao() {
        logger.info("CustomerRequestDao 实例化 ...");
    }
}
