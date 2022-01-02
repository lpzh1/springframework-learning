package com.aop.around;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
//
// 环绕增强
public class GreetingInterceptor implements MethodInterceptor {
	// ① 获取目标类方法并执行，在目标方法前后添加横切逻辑
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object[] args = invocation.getArguments(); // 目标方法的参数
		String clientName = (String)args[0];
		// ② 在目标方法执行前调用的代码
		System.out.println("How are you！Mr."+clientName+".");
		// ③ 通过反射机制调用目标方法
		Object obj = invocation.proceed();
		// ④ 在目标方法执行后调用的增强逻辑
		System.out.println("Please enjoy yourself!");
		
		return obj;
	}
}
