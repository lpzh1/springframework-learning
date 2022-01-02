package com.aop.dao.impl;

import com.aop.dao.FixedDepositDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FixedDepositJdbcDao implements FixedDepositDao {
    Logger log = LoggerFactory.getLogger(FixedDepositJdbcDao.class);

    public void save(String name) {
        log.info("jdbc dao ,"+name);
    }
}
