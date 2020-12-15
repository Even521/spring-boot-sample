package com.even.handler;

import com.even.entity.Apple;
import com.even.service.AppleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author even
 * @date 2019/8/1 0001
 * @describe
 */
@Component
public class AppleHandler {
    @Autowired
    private AppleService appleService;


    public Mono<Boolean> save(Apple apple) {
        return Mono.create(sink -> sink.success(appleService.save(apple)));
    }

    public Mono<Apple> findAppleById(Long id) {
        return Mono.justOrEmpty(appleService.findById(id));
    }

    public Flux<Apple> findAllApple() {
        return Flux.fromIterable(appleService.findAllApple());
    }

    public Mono<Apple> modifyApple(Apple apple) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(appleService.updateApple(apple)));
    }

    public Mono<Boolean> deleteApple(Long id) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(appleService.deleteApple(id)));
    }
}
