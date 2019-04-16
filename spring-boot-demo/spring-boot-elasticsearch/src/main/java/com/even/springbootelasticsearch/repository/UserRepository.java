package com.even.springbootelasticsearch.repository;

import com.even.springbootelasticsearch.domain.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @author even
 * @date 2019/4/16 15:53
 * @describe
 */
@Component
public interface UserRepository extends ElasticsearchRepository<User,String> {



}
