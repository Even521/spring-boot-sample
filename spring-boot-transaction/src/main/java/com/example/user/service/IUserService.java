package com.example.user.service;

import com.example.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author even
 * @since 2018-12-14
 */
public interface IUserService extends IService<User> {
    /**
     * 保存一个用户
     * @return
     * @throws Exception
     */
    boolean saveUser() throws Exception;

}
