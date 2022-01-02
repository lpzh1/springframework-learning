package com.aop.aop;

public class MethodPerformace {
	private long begin;
	private long end;
	private String serviceMethod;

    public MethodPerformace(String serviceMethod){
    	reset(serviceMethod);
    }
    public void printPerformace(){
        // ② 获取目标类执行完成后的系统时间，并统计目标类执行过程所花费的时间
        end = System.currentTimeMillis();
        long elapse = end - begin;
        System.out.println(serviceMethod+"花费"+elapse+"毫秒。");
    }
    public void reset(String serviceMethod){
    	this.serviceMethod = serviceMethod;
        // ① 记录目标了你开始执行点的系统时间
    	this.begin = System.currentTimeMillis();
    }
}
