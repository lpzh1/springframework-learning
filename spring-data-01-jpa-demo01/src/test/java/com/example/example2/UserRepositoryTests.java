package com.example.example2;


import com.example.example2.User;
import com.example.example2.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    UserRepository userRepository;

    @Test
    public void test(){
       User user = new User();
       user.setId(1L);
       user.setName("zhang");
       userRepository.save(user);

    }


}
