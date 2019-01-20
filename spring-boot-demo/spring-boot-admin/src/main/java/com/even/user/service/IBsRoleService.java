package com.even.user.service;

import com.even.user.dto.RoleDTO;
import com.even.user.dto.UserDTO;
import com.even.user.entity.BsRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author even
 * @since 2019-01-14
 */
public interface IBsRoleService extends IService<BsRole> {
    /**
     * 查询所有角色信息
     * @param userId
     * @return
     */
    List<RoleDTO> findByUserId(int userId);
}
