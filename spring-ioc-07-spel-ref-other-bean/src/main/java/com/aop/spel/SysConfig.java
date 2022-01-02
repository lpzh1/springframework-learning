package com.aop.spel;

import javax.sql.DataSource;

//@Component
public class SysConfig {
	private int sessionTimeout;
	private int maxTabPageNum;
	
	private DataSource dataSource;
	// ① 模拟从数据库中获取配置并设置属性值
	public void initFromDB(){
		//从数据库中获取属性配置值
		System.out.println(" init  SysConfig");
		this.sessionTimeout = 30; 
		this.maxTabPageNum = 10;
	}

	public int getSessionTimeout() {
		return sessionTimeout;
	}

	public int getMaxTabPageNum() {
		return maxTabPageNum;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
}
