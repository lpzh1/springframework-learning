package com.ioc.destruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class DemoDestruction implements DestructionAwareBeanPostProcessor {
    Logger logger = LoggerFactory.getLogger(getClass());
    // 在单实例bean销毁之前调用
    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        logger.info("postProcessBeforeDestruction method of DemoDestruction");
    }

}
