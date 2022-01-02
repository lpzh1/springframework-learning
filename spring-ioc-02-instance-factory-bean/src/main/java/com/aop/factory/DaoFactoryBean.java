package com.aop.factory;

import com.aop.dao.FixedDepositDao;
import com.aop.dao.impl.FixedDepositHibernateDao;
import com.aop.dao.impl.FixedDepositJdbcDao;
import com.aop.properties.DaoProperties;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 利用spring提供的FactoryBean接口，可以完全控制我们bean的创建过程
 */
//@Component
public class DaoFactoryBean implements FactoryBean<FixedDepositDao> {
    // TODO 需要注意的是，这里@Value注解拿不到application.properties中的值
    // 要拿到application.properties中的值，需要使用@ConfigurationProperties注解做映射
    // @Value("${dao.type}")
    // private final String daoType = "jdbc";

    @Autowired
    DaoProperties daoProperties;

    @Override
    public FixedDepositDao getObject() throws Exception {
        // TODO 在这里创建你的bean对象，它将被容器管理
        if (daoProperties.getType().equals("hibernate")) {
            return new FixedDepositHibernateDao();
        }
        return new FixedDepositJdbcDao();
    }

    @Override
    public Class<?> getObjectType() {
        return FixedDepositDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
