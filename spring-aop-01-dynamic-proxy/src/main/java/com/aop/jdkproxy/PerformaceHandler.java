package com.aop.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// ① 实现InvocationHandler 接口
public class PerformaceHandler implements InvocationHandler {
    private Object target;
	// ② target 为目标业务类
	public PerformaceHandler(Object target){
		this.target = target;
	}
	//
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// ③-1
		PerformanceMonitor.begin(target.getClass().getName()+"."+ method.getName());
		// ③-2 通过反射调用业务类的目标方法
		Object obj = method.invoke(target, args);
		// ③-1
		PerformanceMonitor.end();
		return obj;
	}
}
