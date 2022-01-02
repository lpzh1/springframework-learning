package com.aop.dao.impl;

import com.aop.dao.FixedDepositDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FixedDepositHibernateDao implements FixedDepositDao {
    Logger log = LoggerFactory.getLogger(FixedDepositHibernateDao.class);

    public void save(String name) {
        log.info("hibernate dao ,"+name);
    }
}
