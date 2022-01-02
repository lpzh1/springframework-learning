package com.ioc;

import com.ioc.config.DemoConfig;
import com.ioc.dao.DemoDao;
import com.ioc.service.DemoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootApplication
public class FactoryPostApplication {

    //public static void main(String[] args) {
    //    SpringApplication.run(FactoryPostApplication.class);
    //}


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        //TODO 为什么使java配置的方式得到的结果和xml配置的结果不一样？
        //AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext(DemoConfig.class);
        ////DemoDao demoDao = context1.getBean(DemoService.class).getDemoDao();
        ////System.out.println(demoDao);
    }
}
