package com.even.service;

import com.even.entity.Apple;

import java.util.Collection;

/**
 * @author even
 * @date 2019/8/1 0001
 * @describe
 */
public interface AppleService {
    /**
     * 保存
     * @param apple
     * @return
     */
    Boolean save(Apple apple);

    /**
     * 根据Id的查询
     * @param id
     * @return
     */
    Apple findById(Long id);

    /**
     * 查询所有
     * @return
     */
    Collection<Apple> findAllApple();

    /**
     * 修改
     * @param apple
     * @return
     */
    Apple updateApple(Apple apple);

    /**
     * 删除
     * @param id
     * @return
     */
    boolean deleteApple(Long id);
}
