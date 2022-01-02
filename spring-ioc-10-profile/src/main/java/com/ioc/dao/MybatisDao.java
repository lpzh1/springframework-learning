package com.ioc.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile("mybatis")
@Repository
public class MybatisDao {
    Logger logger = LoggerFactory.getLogger(getClass());

    public MybatisDao() {
        logger.info("MybatisDao init ");
    }
}
