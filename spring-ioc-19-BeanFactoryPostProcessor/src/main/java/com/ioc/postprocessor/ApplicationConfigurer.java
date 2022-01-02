package com.ioc.postprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.stereotype.Component;

/*
BeanFactoryPostProcessor接口是一个特殊的bean，
spring容器会自动检测并执行一个BeanFactoryPostProcessor bean
 */
//@Component
public class ApplicationConfigurer implements BeanFactoryPostProcessor {
    static Logger logger = LoggerFactory.getLogger(ApplicationConfigurer.class);

    public ApplicationConfigurer() {
        logger.info("Created ApplicationConfigurer instance");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // bean定义名称，就是<bean id='xxx'>标签的id值
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        logger.info("postProcessBeanFactory ......");
        // -- get all the bean definitions
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            String beanName = beanDefinitionNames[i];
            logger.info(beanName);
            // 一个<bean>标签对应的 BeanDefinition对象
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
            // 禁用自动装配
            beanDefinition.setAutowireCandidate(false);
            // -- obtain dependencies of a bean
            if (beanDefinition.isSingleton()) {
                if (hasPrototypeDependency(beanFactory, beanDefinition)) {
                    logger.error("Singleton-scoped " + beanName + " bean is dependent on a prototype-scoped bean.");
                }
            }
        }
    }

    //-- Checks if a bean contains a prototype-scoped dependency
    private boolean hasPrototypeDependency(ConfigurableListableBeanFactory beanFactory,BeanDefinition beanDefinition) {
        boolean isPrototype = false;
        MutablePropertyValues mutablePropertyValues = beanDefinition.getPropertyValues();
        PropertyValue[] propertyValues = mutablePropertyValues.getPropertyValues();

        for (int j = 0; j < propertyValues.length; j++) {
            if (propertyValues[j].getValue() instanceof RuntimeBeanReference) {
                String dependencyBeanName = ((RuntimeBeanReference) propertyValues[j].getValue()).getBeanName();
                BeanDefinition dependencyBeanDef = beanFactory.getBeanDefinition(dependencyBeanName);
                if (dependencyBeanDef.isPrototype()) {
                    isPrototype = true;
                    break;
                }
            }
        }
        return isPrototype;
    }
}
