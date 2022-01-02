package com.aop.after;


import com.aop.service.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by admin on 2020-7-11.
 */
public class AfterAdviceTest {

    public static void main(String[] args) {
        afterAdviceInSpring();
    }
    public static void afterAdviceInSpring(){
        ApplicationContext context = new ClassPathXmlApplicationContext("after.xml");
        Waiter waiter = (Waiter) context.getBean("waiter");
        waiter.greetTo("John After");
    }
}
