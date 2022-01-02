package com.aop.replace;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.Method;

public class MyMethodReplacer implements MethodReplacer, ApplicationContextAware {

    // 此方法将覆盖掉 getMyBean方法

    /**
     *
     * @param obj 被覆盖的方法是实例，此处是CustomerRequestService实例
     * @param method 被覆盖的方法，此处是 getMyBean
     * @param args 被覆盖方法的参数，此处是beanName
     * @return
     * @throws Throwable
     */
    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        return applicationContext.getBean((String)args[0]);
    }

    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
