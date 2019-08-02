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

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public Mono<Apple> findCityById(@PathVariable("id") Long id) {
        return appleHandler.findAppleById(id);
    }

    /**
     * 查询所有
     * @return
     */
    @GetMapping()
    public Flux<Apple> findAllApple() {
        return appleHandler.findAllApple();
    }

    /**
     * 保存
     * @param apple
     * @return
     */
    @PostMapping("/save-apple")
    public Mono<Boolean> saveApple(@RequestBody Apple apple) {
        return appleHandler.save(apple);
    }

    /**
     * 修改
     * @param apple
     * @return
     */
    @PutMapping("/update-apple")
    public Mono<Apple> modifyApple(@RequestBody Apple apple) {
        return appleHandler.modifyApple(apple);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public Mono<Boolean> deleteApple(@PathVariable("id") Long id) {
        return appleHandler.deleteApple(id);
    }
}
