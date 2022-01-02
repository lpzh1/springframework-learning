package com.ioc;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PostApplication {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        context.close();
    }

}
