package com.ioc;

import com.ioc.util.EventSender;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EventSenderApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        EventSender sender1 = context.getBean(EventSender.class);
        //EventSender sender2 = context.getBean(EventSender.class);
        //System.out.println(sender1==sender2);
    }
}
