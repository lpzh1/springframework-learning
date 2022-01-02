package com.ioc.postprocessor;

import com.ioc.common.DependencyResolver;
import com.ioc.common.MyApplicationContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

public class DependencyResolutionBeanPostProcessor implements BeanPostProcessor, Ordered {
    // TODO 注意这句日志
    // Bean 'myApplicationContext' of type [com.ioc.common.MyApplicationContext] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
    // 参考:https://blog.csdn.net/f641385712/article/details/89737791

    private MyApplicationContext myApplicationContext;
    private int order;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof DependencyResolver){
            ((DependencyResolver) bean).resolverDependency(myApplicationContext);
        }

        return bean;
    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public void setMyApplicationContext(MyApplicationContext myApplicationContext) {
        this.myApplicationContext = myApplicationContext;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public int getOrder() {
        return order;
    }
}
