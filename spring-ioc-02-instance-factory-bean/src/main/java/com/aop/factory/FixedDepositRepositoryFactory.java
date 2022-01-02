package com.aop.factory;


import com.aop.dao.FixedDepositDao;
import com.aop.dao.impl.FixedDepositHibernateDao;
import com.aop.dao.impl.FixedDepositJdbcDao;

// 工厂方法
public class FixedDepositRepositoryFactory {


    /**
     * @param daoType 必须是 "jdbc" 或 "hibernate" 之一
     * @return
     */
    public FixedDepositDao getDaoInstance(String daoType) {
        FixedDepositDao dao = null;
        if ("jdbc".equals(daoType)) {
            dao = new FixedDepositJdbcDao();
        } else if ("hibernate".equals(daoType)){
            dao = new FixedDepositHibernateDao();
        }
        return dao;
    }


}
