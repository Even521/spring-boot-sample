package com.even.dao;

import com.even.entity.User;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author even
 * @date 2020/3/30 0030
 * @describe
 */
@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Integer> {
    /**
     * 查询同一年龄所有用户
     * @param age
     * @return
     */
    @Query("select id,name,age from user u where u.age=:age")
    Flux<User> findAllByAge(Integer age);
    @Query("select id,name,age from user u where u.name=:name")
    Mono<User> findByUsername(String name);

}
