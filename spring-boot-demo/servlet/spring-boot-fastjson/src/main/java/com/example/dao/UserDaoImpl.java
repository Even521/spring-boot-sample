package com.example.dao;

import com.example.entity.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

/**
 * Created by Administrator on 2018/12/20 0020.
 *
 * @author even
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public User findById(long id) {
        return User.builder()
                .age(20)
                .birthday(LocalDate.now())
                .id(1L)
                .name("even")
                .build();
    }
}
