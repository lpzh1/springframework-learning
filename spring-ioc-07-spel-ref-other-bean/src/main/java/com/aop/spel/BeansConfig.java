package com.aop.spel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by admin on 2020-7-10.
 */
@Configuration
public class BeansConfig {
    // @Bean 注解的name属性没有设置，默认是方法名
    @Bean(initMethod = "initFromDB")
    public SysConfig sysConfig(){
        SysConfig sysConfig = new SysConfig();
        return sysConfig;
    }
}
