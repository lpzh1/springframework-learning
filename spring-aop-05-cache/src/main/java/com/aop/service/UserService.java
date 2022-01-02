package com.aop.service;

import com.aop.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    Logger logger = LoggerFactory.getLogger(getClass());


    public User userInfo(Long id) {
        logger.info("query userInfo: id="+id);
        User user = new User();
        user.setId(id);
        user.setUsername("zhangSan");
        user.setPass("123");
        return user;
    }

}
