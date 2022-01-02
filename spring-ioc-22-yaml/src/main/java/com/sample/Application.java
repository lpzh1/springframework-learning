package com.sample;

import com.sample.config.ApplicationConfig;
import com.sample.service.UserServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class Application {
   static Log log = LogFactory.getLog(Application.class);

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        Environment env = ac.getEnvironment();
        // TODO 这里为什么为 null ？
        log.info(env.getProperty("server.port"));

        UserServiceImpl userService = ac.getBean("userServiceImpl", UserServiceImpl.class);
        log.info(userService.getServerPort());
        log.info(userService.getServerPath());
        log.info(userService.getEnvironmentProperty("server.port"));
        log.info(userService.getEnvironmentProperty("user.home"));
    }
}
