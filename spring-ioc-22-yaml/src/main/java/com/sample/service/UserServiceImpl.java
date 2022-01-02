package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl {

    @Value("${server.port}")
    private String serverPort;
    @Value("${server.path}")
    private String serverPath;

    @Autowired
    Environment environment;


    public String getServerPort() {
        return serverPort;
    }

    public String getServerPath() {
        return serverPath;
    }


    public String getEnvironmentProperty(String key) {
        return environment.getProperty(key);
    }
}
