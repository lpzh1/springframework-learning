package com.ioc.postprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class EventSenderBeanPostProcessor implements BeanPostProcessor {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info("postProcessBeforeInitialization method of EventSenderBeanPostProcessor invoked ");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("postProcessAfterInitialization method of EventSenderBeanPostProcessor invoked ");
        return bean;
    }
}
