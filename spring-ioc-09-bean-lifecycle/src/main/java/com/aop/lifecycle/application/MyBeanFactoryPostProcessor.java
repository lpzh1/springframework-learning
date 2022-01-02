package com.aop.lifecycle.application;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
// 代码清单 4-34 工厂后处理器：MyBeanFactoryPostProcessor
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

	public void postProcessBeanFactory(ConfigurableListableBeanFactory bf) throws BeansException {
		// 获取 bean 的定义信息，更改其属性
		BeanDefinition bd = bf.getBeanDefinition("car");
		bd.getPropertyValues().addPropertyValue("brand", "奇瑞QQ");
		System.out.println("调用MyBeanFactoryPostProcessor.postProcessBeanFactory()！");
	}

}
