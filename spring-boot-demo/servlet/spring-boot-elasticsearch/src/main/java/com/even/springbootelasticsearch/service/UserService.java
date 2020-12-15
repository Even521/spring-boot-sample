package com.even.springbootelasticsearch.service;

import com.even.springbootelasticsearch.domain.User;

import java.util.Optional;

/**
 * @author even
 * @date 2019/4/16 15:55
 * @describe
 */
public interface UserService {
    Optional<User> findById(String id);

    /**
     * 保存用户
     * @param user
     * @return
     */
    User save(User user);
}
