package com.ioc.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

//@Profile("hibernate")
@Repository
@com.ioc.anno.HibernateDao("")
public class HibernateDao {
    Logger logger = LoggerFactory.getLogger(getClass());

    public HibernateDao() {
        logger.info("HibernateDao init ");
    }
}
