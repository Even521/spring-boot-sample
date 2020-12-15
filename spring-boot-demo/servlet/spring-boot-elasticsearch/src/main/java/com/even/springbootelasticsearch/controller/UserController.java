package com.even.springbootelasticsearch.controller;

import com.even.springbootelasticsearch.domain.User;
import com.even.springbootelasticsearch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author even
 * @date 2019/4/16 16:36
 * @describe
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/save")
    public boolean save(){
        User user= new User("1","userName","23");
        userService.save(user);
        return  true;
    }
}
