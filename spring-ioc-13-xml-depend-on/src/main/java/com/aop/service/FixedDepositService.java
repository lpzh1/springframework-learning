package com.aop.service;

import com.aop.costants.Constants;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FixedDepositService {

    private EventSender eventSender;

    // 读取配置
    public FixedDepositService(String configFile) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 从appConfig.properties文件中读取内容,创建成员变量实例 eventSender

        ClassPathResource resource = new ClassPathResource(configFile);
        if (resource.exists()) {
            InputStream in = resource.getInputStream();
            Properties properties = new Properties();
            properties.load(in);
            String className = properties.getProperty(Constants.CLASS_NAME_KEY);
            if (className != null) {
                Class<?> forName = Class.forName(className);
                eventSender = (EventSender) forName.newInstance();
                System.out.println("create eventSender successfully: "+eventSender);
            }
            //properties.store(new FileOutputStream(""),null);
        }
        if (eventSender == null)
            System.out.println("create eventSender failure: "+eventSender);

    }
}
