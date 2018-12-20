package com.example.dao;

import com.example.entity.User;

/**
 * Created by Administrator on 2018/12/20 0020.
 *
 * @author even
 */
public interface UserDao {
    /**
     * 根据ID查询
     * @param id
     * @return
     */
    User findById(long id);
}
