package com.ioc.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class lnstanceValidationBeanPostProccessor implements BeanPostProcessor, Ordered {
    Logger logger = LoggerFactory.getLogger(getClass());

    public lnstanceValidationBeanPostProccessor(){
        logger.info("created lnstanceValidationBeanPostProccessor instance");
    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (bean instanceof InstanceValidate){
            ((InstanceValidate)bean).validateInstance();
        }
        return bean;
    }


    private int order;
    @Override
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
