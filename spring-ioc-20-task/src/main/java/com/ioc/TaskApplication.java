package com.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class TaskApplication {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        //context.start();

        System.in.read();
    }
}
