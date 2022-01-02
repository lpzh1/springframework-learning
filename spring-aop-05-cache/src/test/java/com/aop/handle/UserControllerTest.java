package com.aop.handle;

import com.aop.config.CachingConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {CachingConfig.class})
public class UserControllerTest {

    @Autowired
    UserController userController;

    @Test
    public void getInfo(){
        //System.out.println(userController);
        // 缓存效果测试
        // 使用相同的id值调用两次，控制台只打印一次调用UserService的日志，说明缓存已经起作用
        userController.getUserInfo(2L);
        userController.getUserInfo(2L);
    }
}
