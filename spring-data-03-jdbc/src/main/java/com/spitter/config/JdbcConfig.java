package com.spitter.config;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {

    // 配置jndi数据源
    //public JndiObjectFactoryBean dataSource(){
    //    JndiObjectFactoryBean jndiBean = new JndiObjectFactoryBean();
    //    jndiBean.setJndiName("jdbc/SpitterDS");
    //    jndiBean.setResourceRef(true);
    //    jndiBean.setProxyInterface(javax.sql.DataSource.class);
    //    return jndiBean;
    //}

    //@Bean
    //public BasicDataSource dataSource(){
    //    BasicDataSource dataSource = new BasicDataSource();
    //    dataSource.setDriverClassName("");
    //    dataSource.setUrl("");
    //    dataSource.setUsername("");
    //    dataSource.setPassword("");
    //    dataSource.setInitialSize(5);
    //    dataSource.setMaxActive(10);
    //    return dataSource;
    //}

    // 嵌入式数据源
    @Bean
    public DataSource dataSource(){
        //EmbeddedDatabase 继承 DataSource接口
        EmbeddedDatabase database = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:sql/schema.sql")
                .addScript("classpath:sql/test-data.sql")
                .build();
        return database;
    }


    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public NamedParameterJdbcTemplate NamedJdbcTemplate(DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }

}
