package com.aop.spel;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationManager {
	// 引用其他spring容器中的其他bean实例的属性
	@Value("#{sysConfig.sessionTimeout}")
	private int sessionTimeout;

	@Value("#{sysConfig.maxTabPageNum}")
	private int maxTabPageNum;

	public int getSessionTimeout() {
		return sessionTimeout;
	}
	public void setSessionTimeout(int sessionTimeout) {
		this.sessionTimeout = sessionTimeout;
	}
	public int getMaxTabPageNum() {
		return maxTabPageNum;
	}
	public void setMaxTabPageNum(int maxTabPageNum) {
		this.maxTabPageNum = maxTabPageNum;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
