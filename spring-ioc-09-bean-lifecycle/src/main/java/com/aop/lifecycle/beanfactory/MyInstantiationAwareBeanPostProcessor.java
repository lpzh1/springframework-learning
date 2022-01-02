package com.aop.lifecycle.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

// 代码清单 4-30 InstantiationAwareBeanPostProcessorAdapter的实现类
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    // ① 接口方法：实例化bean前调用
    public Object postProcessBeforeInstantiation(Class beanClass, String beanName) throws BeansException {
        // ①-1 仅对容器中的car bean处理
        if ("car".equals(beanName)) {
            System.out.println("MyInstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation");
        }
        return null;
    }
    // ② 接口方法：在实例化bean后调用
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        // ②-1 仅对容器中的car bean处理
        if ("car".equals(beanName)) {
            System.out.println("InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation");
        }
        return true;
    }
    // ③ 接口方法：在设置某个属性后调用
    public PropertyValues postProcessPropertyValues(
            PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName)
            throws BeansException {
        // ③-1 仅对容器中的car bean进行处理，还可以pdst入参进行过滤，
        // 仅对 car 的某个属性进行处理
        if ("car".equals(beanName)) {
            System.out.println("InstantiationAwareBeanPostProcessor.postProcessPropertyValues");
        }
        return pvs;
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
