package com.even.springbootknife4j.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * @author even
 * @date 2020/12/15 0015 下午 12:04
 * @describe
 */
@RestController
@RequestMapping("/test")
@Api(tags = "测试")
public class DemoSwaggerController {

    @ApiOperation("获取swagger3.0")
    @GetMapping("/get")
    public Mono<String> hello(){
        return Mono.just("hello swagger3.0");
    }
}
