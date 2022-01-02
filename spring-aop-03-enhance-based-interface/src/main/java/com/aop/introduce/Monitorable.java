package com.aop.introduce;

// 用于表示目标类是否支持性能监视的接口
public interface Monitorable {
    void setMonitorActive(boolean active);
}
