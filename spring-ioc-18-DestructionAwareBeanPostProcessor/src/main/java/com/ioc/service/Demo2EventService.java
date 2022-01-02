package com.ioc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo2EventService {
    Logger logger = LoggerFactory.getLogger(getClass());

    private void destroy() {
        logger.info("destroy method of Demo2EventService");
    }
}
