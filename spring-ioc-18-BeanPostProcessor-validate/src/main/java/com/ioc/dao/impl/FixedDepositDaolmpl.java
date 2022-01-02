package com.ioc.dao.impl;

import com.ioc.common.InstanceValidate;
import com.ioc.util.DbConnection;
import com.ioc.dao.FixedDepositDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FixedDepositDaolmpl implements FixedDepositDao,InstanceValidate {
    Logger logger = LoggerFactory.getLogger(getClass());

    private DbConnection dbConnection;

    public FixedDepositDaolmpl(){
        logger.info("FixedDepositDaolmpl invoked .....");
    }


    public void initializerDbConnection(){
        logger.info("initializerDbConnection invoked .....");
        dbConnection = DbConnection.getInstance();
    }


    @Override
    public void validateInstance() {
        logger.info("validateInstance invoked .....");
        if (dbConnection==null){
            logger.error("failed to obtain DbConnection instance .....");
        }
    }
}
