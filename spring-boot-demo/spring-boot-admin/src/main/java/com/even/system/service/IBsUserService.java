package com.even.system.service;

import com.even.system.dto.UserDTO;
import com.even.system.entity.BsUser;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author even
 * @since 2019-01-14
 */
public interface IBsUserService extends IService<BsUser> {
    /**
     * 根据邮箱或者用户名查询
     * @param name
     * @return
     */
    BsUser findByName(String name) throws UsernameNotFoundException;

    /**
     * 查询用户所有角色
     * @param name
     * @return
     */
    UserDTO findByUserName(String name);

    /**
     * 不存在
     * @param name
     * @return
     */
    boolean notExit(String name);

    /**
     * 创建一个新用户
     * @param user
     * @return
     */
    UserDTO createUser(BsUser user) ;


}
