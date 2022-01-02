package com.aop.encrypt;

import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created by admin on 2020-7-9.
 */
//@Configuration
public class EncryptPropertyConfig {

    @Bean(name = "encryptProperty")
    public EncryptPropertyPlaceholderConfigurer getEncryptPropertyPlaceholderConfigurer(){
        EncryptPropertyPlaceholderConfigurer placeholderConfigurer = new EncryptPropertyPlaceholderConfigurer();
        Resource resource = new ClassPathResource("classpath:jdbc.properties");
        placeholderConfigurer.setLocation(resource);
        return placeholderConfigurer;
    }

}
