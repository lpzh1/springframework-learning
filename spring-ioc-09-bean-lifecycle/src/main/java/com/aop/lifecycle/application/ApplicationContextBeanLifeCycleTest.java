package com.aop.lifecycle.application;

import com.aop.pojo.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextBeanLifeCycleTest {

    private static void LifeCycleInApplicationContext() {

        //①下面两句装载配置文件并启动容器
        // 原来是：com/smart/beanfactory/beans.xml
//        Resource res = new ClassPathResource("com/smart/_452_BeanFactory_lifecycle/beans.xml");
//
//        BeanFactory bf = new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((DefaultListableBeanFactory) bf);
//        reader.loadBeanDefinitions(res);

        ApplicationContext context = new ClassPathXmlApplicationContext("application-context-lifecycle.xml");


        //②向容器中注册MyBeanPostProcessor后处理器
        // ((ConfigurableBeanFactory) bf).addBeanPostProcessor(new MyBeanPostProcessor());
        // 直接在 beans.xml 文件中配置


        //③向容器中注册MyInstantiationAwareBeanPostProcessor后处理器
        // ((ConfigurableBeanFactory) bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
        // 直接在 beans.xml 文件中配置

        //④第一次从容器中获取car，将触发容器实例化该Bean，这将引发Bean生命周期方法的调用。
        Car car1 = (Car) context.getBean("car");
        car1.introduce();
        car1.setColor("红色");


        //⑤第二次从容器中获取car，直接从缓存池中获取
        Car car2 = (Car) context.getBean("car");

        //⑥查看car1和car2是否指向同一引用
        System.out.println("car1==car2:" + (car1 == car2));

        //⑦关闭容器
        // ((DefaultListableBeanFactory) context).destroySingletons();
        ((ClassPathXmlApplicationContext) context).close();

    }

    public static void main(String[] args) {
        LifeCycleInApplicationContext();
    }
}
