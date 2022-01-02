package com.ioc.factory;

import com.ioc.util.EventSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class EventSenderFactoryBean implements FactoryBean<EventSender>, InitializingBean {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public EventSender getObject() throws Exception {
        logger.info("getObject method of EventSenderFactoryBean invoked ");
        EventSender eventSender = new EventSender();
        eventSender.setEvent("my event");
        return eventSender;
    }

    @Override
    public Class<?> getObjectType() {
        return EventSender.class;
    }

    @Override
    public boolean isSingleton() {
        // TODO 即使是单例，在spring容器启动时，没有调用getObject()方法
        // 这与直接在spring容器定义的单例不同
        return true;
    }

    // 初始化方法
    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("afterPropertiesSet method of EventSenderFactoryBean invoked ");
    }
}
