package com.even.controller;

import com.even.entity.Apple;
import com.even.handler.AppleHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author even
 * @date 2019/8/1 0001
 * @describe
 */
@RestController
@RequestMapping(value = "/apple")
public class AppleController {


   @Autowired
   private AppleHandler appleHandler;

    @GetMapping(value = "/{id}")
    public Mono<Apple> findCityById(@PathVariable("id") Long id) {
        return appleHandler.findAppleById(id);
    }

    @GetMapping()
    public Flux<Apple> findAllApple() {
        return appleHandler.findAllApple();
    }

    @PostMapping("/save-apple")
    public Mono<Boolean> saveApple(@RequestBody Apple apple) {
        return appleHandler.save(apple);
    }

    @PutMapping("/update-apple")
    public Mono<Apple> modifyApple(@RequestBody Apple apple) {
        return appleHandler.modifyApple(apple);
    }

    @DeleteMapping(value = "/{id}")
    public Mono<Boolean> deleteApple(@PathVariable("id") Long id) {
        return appleHandler.deleteApple(id);
    }
}
