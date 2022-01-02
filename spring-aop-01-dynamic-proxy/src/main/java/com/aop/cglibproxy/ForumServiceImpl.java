package com.aop.cglibproxy;

import com.aop.jdkproxy.ForumService;

public class ForumServiceImpl implements ForumService {

	public void removeTopic(int topicId) {
		// ①-1 开始对该方法进行性能监视

		System.out.println("模拟删除Topic记录:"+topicId);
		try {
			Thread.currentThread().sleep(20);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		// ①-2 结束对该方法的性能监视

	}

	public void removeForum(int forumId) {
		// ②-1 开始对该方法进行性能监视

		System.out.println("模拟删除Forum记录:"+forumId);
		try {
			Thread.currentThread().sleep(40);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		// ②-2 结束对该方法的性能监

	}
}
