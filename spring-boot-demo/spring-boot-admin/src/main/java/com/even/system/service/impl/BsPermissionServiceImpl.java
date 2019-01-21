package com.even.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.even.system.dto.PermissionDTO;
import com.even.system.entity.BsPermission;
import com.even.system.mapper.BsPermissionMapper;
import com.even.system.service.IBsPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author even
 * @since 2019-01-14
 */
@Service
public class BsPermissionServiceImpl extends ServiceImpl<BsPermissionMapper, BsPermission> implements IBsPermissionService {

    @Override
    public List<PermissionDTO> findByRoleId(int roleId) {
        return this.baseMapper.findByRoleId(new QueryWrapper<PermissionDTO>().eq("role_id",roleId));
    }
}
