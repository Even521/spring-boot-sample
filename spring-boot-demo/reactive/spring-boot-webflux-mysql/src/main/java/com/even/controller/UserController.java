package com.even.controller;

import com.even.entity.User;
import com.even.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @author even
 * @date 2020/3/30 0030
 * @describe
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{age}")
    Flux<User> findAllByAge(@PathVariable("age") Integer age){
        return userService.findAllByAge(age);
    }

    @PostMapping("/save")
    Mono<User> save(User user){
        return userService.save(user);
    }

    @PutMapping("/update")
    Mono<User> update(User user){
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    Mono<Void> detele(@PathVariable("id")  Integer id){
        return userService.delete(id);
    }

    @GetMapping(value = "/find-all", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<User> findAll() {
        return this.userService.findAll().delayElements(Duration.ofSeconds(2));
    }


   
}
