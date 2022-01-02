package com.aop;

import com.aop.aop.ForumService;
import com.aop.aop.ForumServiceImpl;

/**
 * Created by admin on 2020-7-10.
 *
 * 测试拥有性能监视能力的ForumService方法！
 */
public class TestForumService {
    public static void main(String[] args) {
        ForumService forumService = new ForumServiceImpl();
        forumService.removeForum(10);
        forumService.removeTopic(1012);
    }
}
