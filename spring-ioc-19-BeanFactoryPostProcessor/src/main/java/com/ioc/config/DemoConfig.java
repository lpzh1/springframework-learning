package com.ioc.config;

import com.ioc.dao.DemoDao;
import com.ioc.postprocessor.ApplicationConfigurer;
import com.ioc.service.DemoService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DemoConfig {
    @Bean
    public static ApplicationConfigurer applicationConfigurer(){
        return new ApplicationConfigurer();
    }

    @Bean("demoDao")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public DemoDao demoDao(){
        return new DemoDao();
    }

    //@Bean
    //@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    //public DemoService demoService(){
    //    DemoService demoService = new DemoService();
    //    demoService.setDemoDao(demoDao());
    //    return demoService;
    //}



}
