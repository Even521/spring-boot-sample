package com.even.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/1/7 0007.
 *
 * @author even
 */
@RestController
@Slf4j
public class TestController {
    @GetMapping("/user")
    public Authentication getUser(Authentication authentication) {
        log.info("auth : {}", authentication);
        return authentication;
    }

}
