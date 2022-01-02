package com.aop.cglibproxy;

import com.aop.jdkproxy.ForumService;
import com.aop.jdkproxy.PerformaceHandler;

import java.lang.reflect.Proxy;

public class ForumServiceTest {
	public static void main(String[] args) {
		//jdkProxy();
		CGLibProxy();
	}


	//@Test
	public static void jdkProxy() {


		// 使用JDK动态代理
		// ① 目标业务类
		ForumService target = new ForumServiceImpl();
		// ② 将目标业务类和横切代码编制到一起
		PerformaceHandler handler = new PerformaceHandler(target);
		// ③ 根据编制目标业务类逻辑和性能监视逻辑创建代理实例
		ForumService proxy = (ForumService) Proxy.newProxyInstance(target
				.getClass().getClassLoader(),
				target.getClass().getInterfaces(), handler);
		// ④ 调用代理实例方法
		proxy.removeForum(10);
		proxy.removeTopic(1012);


		
	}


	public  void CodeProxy(){
		// 业务类正常编码的测试
		//ForumService forumService = new ForumServiceImpl();
		// forumService.removeForum(10);
		// forumService.removeTopic(1012);
	}

	public static void CGLibProxy(){
		//使用CGLib动态代理
		CglibProxy cglibProxy = new CglibProxy();
		ForumService forumService = (ForumService)cglibProxy.getProxy(ForumServiceImpl.class);
		forumService.removeForum(10);
		forumService.removeTopic(1023);
	}
}
