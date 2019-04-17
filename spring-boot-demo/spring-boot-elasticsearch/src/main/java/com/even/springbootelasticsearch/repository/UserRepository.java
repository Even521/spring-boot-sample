package com.even.springbootelasticsearch.repository;

import com.even.springbootelasticsearch.domain.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
/**
 * @author even
 * @date 2019/4/16 15:53
 * @describe
 */
public interface UserRepository extends ElasticsearchRepository<User,String> {



}
