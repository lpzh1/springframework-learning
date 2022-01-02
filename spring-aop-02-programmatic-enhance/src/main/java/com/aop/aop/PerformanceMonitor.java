package com.aop.aop;

public class PerformanceMonitor {
	// ① 通过一个 ThreadLocal 类保存与调用线程相关的性能监视信息
	private static ThreadLocal<MethodPerformace> performaceRecord = new ThreadLocal<MethodPerformace>();
	// ② 启动对某一个目标方法的性能监视
	public static void begin(String method) {
		System.out.println("begin monitor...");
		MethodPerformace mp = performaceRecord.get();
		if(mp == null){
			mp = new MethodPerformace(method);
			performaceRecord.set(mp);
		}else{
		    mp.reset(method);	
		}
	}
	public static void end() {
		System.out.println("end monitor...");
		MethodPerformace mp = performaceRecord.get();
		// ③ 打印出性能监视的结果信息
		mp.printPerformace();
	}
}
