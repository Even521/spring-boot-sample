package com.even.service.impl;

import com.even.entity.Apple;
import com.even.service.AppleService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author even
 * @date 2019/8/1 0001
 * @describe
 */
@Service
public class AppleRepository implements AppleService {
    private ConcurrentMap<Long, Apple> repository = new ConcurrentHashMap<>();

    private static final AtomicLong idGenerator = new AtomicLong(0);


    @Override
    public Boolean save(Apple apple) {
        Long id=idGenerator.incrementAndGet();
        apple.setId(id);
        repository.put(id,apple);
        return id>0?true:false;
    }

    @Override
    public Apple findById(Long id) {
        return repository.get(id);
    }

    @Override
    public Collection<Apple> findAllApple() {
        return repository.values();
    }

    @Override
    public Apple updateApple(Apple apple) {
        repository.put(apple.getId(),apple);
        return apple;
    }

    @Override
    public boolean deleteApple(Long id) {
        repository.remove(id);
        return id>0?true:false;
    }
}
