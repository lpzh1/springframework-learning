package com.aop.handle;

import com.aop.domain.User;
import com.aop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Cacheable(cacheNames = {"user"})
    public User getUserInfo(Long id) {
        User user = userService.userInfo(id);
        return user;
    }

}
