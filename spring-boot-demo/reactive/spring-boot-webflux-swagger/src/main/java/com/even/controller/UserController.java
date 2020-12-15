package com.even.controller;

import com.even.vo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * @author even
 * @date 2020/7/20 0020
 * @describe
 */
@Api(tags = "用户管理")
@RestController
public class UserController {

    @ApiOperation("创建用户")
    @PostMapping("/user")
    public Mono<User> save(@Valid User user){
        return Mono.create(userMonoSink -> {
          userMonoSink.success(user);
        });
    }
    @ApiOperation("用户详情")
    @GetMapping("/users/{id}")
    public Mono<User> findById(@PathVariable Long id) {
        User user = new User("bbb", 21, "上海", "aaa@bbb.com");
        return Mono.justOrEmpty(user);
    }
}

