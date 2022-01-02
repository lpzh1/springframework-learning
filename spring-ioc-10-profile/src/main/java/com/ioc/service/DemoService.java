package com.ioc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    Logger logger = LoggerFactory.getLogger(getClass());
    public DemoService() {
        logger.info("DemoService init ");

    }
}
