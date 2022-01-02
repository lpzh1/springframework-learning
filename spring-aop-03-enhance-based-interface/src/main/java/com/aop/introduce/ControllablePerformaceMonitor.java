package com.aop.introduce;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

// 性能监视的可控功能
public class ControllablePerformaceMonitor
        extends
        DelegatingIntroductionInterceptor implements Monitorable {
    // ①
    private ThreadLocal<Boolean> MonitorStatusMap = new ThreadLocal<Boolean>();

    // ②
    public void setMonitorActive(boolean active) {
        MonitorStatusMap.set(active);
    }

    // ③ 拦截方法
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object obj = null;
        // ④ 通过判断代理的状态决定是否开启性能监视的功能
        if (MonitorStatusMap.get() != null && MonitorStatusMap.get()) {
            PerformanceMonitor.begin(mi.getClass().getName() + "." + mi.getMethod().getName());
            obj = super.invoke(mi);
            PerformanceMonitor.end();
        } else {
            obj = super.invoke(mi);
        }
        return obj;
    }

    public void test() {
        // TODO Auto-generated method stub
        System.out.println("dd");
    }
}
