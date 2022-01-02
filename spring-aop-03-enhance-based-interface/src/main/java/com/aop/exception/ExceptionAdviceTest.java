package com.aop.exception;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by admin on 2020-7-11.
 */
public class ExceptionAdviceTest {
    public static void main(String[] args) {
        aroundAdviceInSpring();
    }
    public static void aroundAdviceInSpring(){
        ApplicationContext context = new ClassPathXmlApplicationContext("exception.xml");
        // 获取代理对象
        ForumService forumService = (ForumService) context.getBean("forumService");
        forumService.removeForum(3);
    }
}
