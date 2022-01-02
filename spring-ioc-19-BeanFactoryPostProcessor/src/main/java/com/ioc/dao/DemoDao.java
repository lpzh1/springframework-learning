package com.ioc.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Component("demoDao")
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DemoDao {
    static Logger logger = LoggerFactory.getLogger(DemoDao.class);

    public DemoDao() {
        logger.info("DemoDao is created ...");
    }
}
