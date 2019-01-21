package com.even.system.service;

import com.even.system.dto.RoleDTO;
import com.even.system.entity.BsRole;
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
