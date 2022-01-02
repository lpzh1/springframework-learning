package com.ioc.postprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

// 针对容器中的所用bean进行增强
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    Logger logger = LoggerFactory.getLogger(getClass());

    //  benPostProcessor
    // 在 调用 setter 方法完成依赖注入之后
    // 在初始化方法（init-method）被调用之前
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info("CustomerRequestService's postProcessBeforeInitialization() method has been invoked !");
        //System.out.println(bean.getClass().getName());
        //System.out.println(beanName);
        return bean;
    }

    // 此方法在bean实例的初始化方法被调用之后调用
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("CustomerRequestService's postProcessAfterInitialization() method has been invoked !");
        return bean;
    }
}
