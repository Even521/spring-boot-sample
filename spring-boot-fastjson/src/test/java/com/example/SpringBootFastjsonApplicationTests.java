package com.example;

import com.alibaba.fastjson.JSON;
import com.example.entity.User;
import com.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootFastjsonApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        User user=userService.findById(1);
        System.out.println(JSON.toJSON(user));
    }

}

