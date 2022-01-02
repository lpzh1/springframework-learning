package com.aop;

import com.aop.dao.FixedDepositDao;
import com.aop.factory.DaoFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;


//@ConfigurationPropertiesScan
@ImportResource(locations = {"classpath:application-context.xml"})
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);

        //// 得到工厂创建的对象
        //FixedDepositDao dao = context.getBean(FixedDepositDao.class, "dao");
        //dao.save("刘强东");
        //// 得到工厂对象
        //FixedDepositRepositoryFactory daoFactory = context.getBean(FixedDepositRepositoryFactory.class, "daoFactory");

        FixedDepositDao dao1 = (FixedDepositDao) context.getBean("dao1");
        dao1.save("刘华强");

        // 得到工厂对象本身
        DaoFactoryBean bean = context.getBean(DaoFactoryBean.class, "&dao1");
        System.out.println(bean instanceof DaoFactoryBean);
        System.out.println(dao1==bean);
    }



}