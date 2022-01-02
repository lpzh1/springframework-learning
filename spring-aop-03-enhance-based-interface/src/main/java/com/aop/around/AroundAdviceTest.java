package com.aop.around;


import com.aop.service.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by admin on 2020-7-11.
 */
public class AroundAdviceTest {

    public static void main(String[] args) {
        aroundAdviceInSpring();
    }
    public static void aroundAdviceInSpring(){
        ApplicationContext context = new ClassPathXmlApplicationContext("around.xml");
        Waiter waiter = (Waiter) context.getBean("waiter");
        waiter.greetTo("John Around");
    }
}
