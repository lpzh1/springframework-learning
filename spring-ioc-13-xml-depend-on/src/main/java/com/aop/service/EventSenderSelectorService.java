package com.aop.service;

import com.aop.costants.Constants;
import org.springframework.core.io.ClassPathResource;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class EventSenderSelectorService {

    // 存储配置
    public EventSenderSelectorService(String configFile) throws IOException {
        // 初始化时，将一个类名写入属性配置文件
        ClassPathResource resource = new ClassPathResource(configFile);
        OutputStream out = new FileOutputStream(resource.getFile());
        Properties properties = new Properties();
        properties.setProperty(Constants.CLASS_NAME_KEY,Constants.CLASS_NAME_VALUE);
        properties.store(out,null);

    }


    public void destroy() throws IOException {
        ClassPathResource resource = new ClassPathResource("appConfig.properties");
        InputStream in = resource.getInputStream();
        OutputStream out = new FileOutputStream(resource.getFile());
        Properties properties = new Properties();
        properties.load(in);
        properties.clear();
        properties.store(out,null);
    }
}
