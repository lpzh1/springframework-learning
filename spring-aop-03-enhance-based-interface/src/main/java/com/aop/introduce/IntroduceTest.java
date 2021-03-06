package com.aop.introduce;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import static org.testng.Assert.*;

public class IntroduceTest {
    public static void main(String[] args) {
        introduce();
    }

    //    @Test
    public static void introduce() {

        String configPath = "introduce.xml";

        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        ForumService forumService = (ForumService) ctx.getBean("forumService");

        forumService.removeForum(10);
        forumService.removeTopic(1022);

        Monitorable moniterable = (Monitorable) forumService;
        moniterable.setMonitorActive(true);
        forumService.removeForum(10);
        forumService.removeTopic(1022);
    }
}
