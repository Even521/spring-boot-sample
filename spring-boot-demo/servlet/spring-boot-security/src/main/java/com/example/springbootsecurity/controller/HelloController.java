package com.example.springbootsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/1/4 0004.
 *
 * @author even
 */
@RestController
public class HelloController {
    @GetMapping("hello")
    public String hello() {
        return "hello spring security";
    }
}
