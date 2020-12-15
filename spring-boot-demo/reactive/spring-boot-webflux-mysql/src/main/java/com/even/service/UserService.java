package com.even.service;

import com.even.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author even
 * @date 2020/3/30 0030
 * @describe
 */
public interface UserService {
    /**
     * 查询同一年龄所有用户
     * @param age
     * @return
     */
    Flux<User> findAllByAge(int age);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Mono<User> findById(Integer id);

    /**
     * 保存
     * @param user
     * @return
     */
    Mono<User> save(User user);

    /**
     * 修改
     * @param user
     * @return
     */
    Mono<User> update(User user);

    /**
     * 删除
     * @param id
     * @return
     */
    Mono<Void> delete(Integer id);

    /**
     * 查询所有用户
     * @return
     */
    Flux<User> findAll();


}
