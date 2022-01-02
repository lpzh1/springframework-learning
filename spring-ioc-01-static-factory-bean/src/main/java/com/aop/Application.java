package com.aop;

import com.aop.dao.FixedDepositDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations = {"classpath:application-context.xml"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);

        // 得到工厂创建的对象
        FixedDepositDao dao = context.getBean(FixedDepositDao.class, "dao");
        dao.save("马云");
        // 得到工厂对象本身
        // 注意: 容器并没实例化静态工厂，所以这里会报错
        //FixedDepositRepositoryFactory factory = (FixedDepositRepositoryFactory) context.getBean("&dao");
        //FixedDepositRepositoryFactory factory = (FixedDepositRepositoryFactory) context.getBean(FixedDepositRepositoryFactory.class);
    }
}
