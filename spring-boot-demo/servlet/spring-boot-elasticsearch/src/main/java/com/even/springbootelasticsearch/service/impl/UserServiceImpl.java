package com.even.springbootelasticsearch.service.impl;

import com.even.springbootelasticsearch.domain.User;
import com.even.springbootelasticsearch.repository.UserRepository;
import com.even.springbootelasticsearch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author even
 * @date 2019/4/16 15:57
 * @describe
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;
    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
