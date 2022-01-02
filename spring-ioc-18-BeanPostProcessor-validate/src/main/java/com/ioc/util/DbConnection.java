package com.ioc.util;

public class DbConnection {

    public static DbConnection getInstance() {
        return  new DbConnection();
    }


    public static void releaseConnection(DbConnection conn) {
        //
    }
}
