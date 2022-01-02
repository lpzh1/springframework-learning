package com.aop.config;

import com.aop.properties.DaoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties({DaoProperties.class})
@Configuration
public class PropertiesConfig {

}
