package com.ioc.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Demo1EventService
        implements DisposableBean
{
    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void destroy() throws Exception {
        logger.info("destroy method of Demo1EventService");
    }
}
