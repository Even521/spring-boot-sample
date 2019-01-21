package com.even.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.even.system.dto.PermissionDTO;
import com.even.system.entity.BsPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author even
 * @since 2019-01-14
 */
public interface BsPermissionMapper extends BaseMapper<BsPermission> {
    List<PermissionDTO> findByRoleId(@Param("ew") QueryWrapper queryWrapper);
}
