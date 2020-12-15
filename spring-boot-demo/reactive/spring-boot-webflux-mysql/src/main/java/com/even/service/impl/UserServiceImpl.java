package com.even.service.impl;

import com.even.dao.UserRepository;
import com.even.entity.User;
import com.even.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author even
 * @date 2020/3/30 0030
 * @describe
 */
@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public Flux<User> findAllByAge(int age) {
        return userRepository.findAllByAge(age);
    }

    @Override
    public Mono<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public Mono<User> save(User user) {
        return userRepository.save(user)
                .onErrorResume(e ->
                        userRepository.findByUsername(user.getName())
                                .flatMap(u -> {
                                    user.setId(u.getId());
                                    return userRepository.save(user);
                                }));

    }

    @Override
    public Mono<User> update(User user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<Void> delete(Integer id) {
        return userRepository.deleteById(id);
    }

    @Override
    public Flux<User> findAll() {
        return userRepository.findAll();
    }
}
