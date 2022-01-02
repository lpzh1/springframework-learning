package com.ioc.service.impl;

import com.ioc.common.DependencyResolver;
import com.ioc.common.MyApplicationContext;
import com.ioc.service.FixedDepositService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// 没有直接继承 ApplicationContextAware,而是实现 DependencyResolver 接口
public class FixedDepositServiceImpl implements FixedDepositService,
        DependencyResolver
{
    Logger logger = LoggerFactory.getLogger(getClass());
    // dao依赖


    @Override
    public void resolverDependency(MyApplicationContext myApplicationContext) {
        logger.info("Resolving dependencies of FixedDepositServiceImpl instance");
        //fixedDepositDao = myApplicationContext.getBean(FixedDepositDao.class);
    }
}
