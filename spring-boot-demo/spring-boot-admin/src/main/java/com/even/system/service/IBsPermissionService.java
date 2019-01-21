package com.even.system.service;

import com.even.system.dto.PermissionDTO;
import com.even.system.entity.BsPermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author even
 * @since 2019-01-14
 */
public interface IBsPermissionService extends IService<BsPermission> {
    /**
     * 根据角色ID查询角色所有权限
     * @param roleId
     * @return
     */
     List<PermissionDTO> findByRoleId(int roleId);
}
