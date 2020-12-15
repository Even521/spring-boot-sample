package com.even.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.Console;

/**
 * @author even
 * @date 2020/12/15 0015 下午 15:43
 * @describe
 */
@RestController
@RequestMapping(value = "/web")
@Log4j2
public class WebClientDemo {


    @GetMapping(value = "/baidu")
    public Mono<String> getBaiDu() {
        Mono<String> s = WebClient.create().method(HttpMethod.GET)
                .uri("https://www.cdxiangxue.com.cn")
                .retrieve().bodyToMono(String.class);

       s.subscribe(System.out::println);
        return s;
    }

}
