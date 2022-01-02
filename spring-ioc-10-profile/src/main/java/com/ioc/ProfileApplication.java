package com.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProfileApplication {

    public static void main(String[] args) {
        System.setProperty("spring.profiles.active","mybatis,hibernate,default");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    }
}
