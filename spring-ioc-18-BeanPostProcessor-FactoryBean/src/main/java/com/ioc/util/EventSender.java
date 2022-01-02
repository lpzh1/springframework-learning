package com.ioc.util;

import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

@Setter
public class EventSender implements InitializingBean {
    Logger logger = LoggerFactory.getLogger(getClass());

    private String event;

    public EventSender() {
        logger.info("created an EventSender instance ");
    }

    public void send() {
        logger.info("send an event");
    }

    // 对于这个初始化方法
    // BeanPostProcessor只会调用 postProcessAfterInitialization
    // 不会调用 postProcessBeforeInitialization
    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("afterPropertiesSet method of EventSender invoked ");
    }
}
