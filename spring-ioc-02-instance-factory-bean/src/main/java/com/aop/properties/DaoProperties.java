package com.aop.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;


// TODO @PropertySource怎么用
@PropertySource("classpath:META-INF/dao.properties")
@ConfigurationProperties(prefix = "dao")
//@Component
@Getter@Setter
public class DaoProperties {
    // 属性映射一般设置默认值，不然容易导致 NullPointerException
    private String type = "jdbc";
}
