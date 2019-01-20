package com.even.user.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.even.user.dto.RoleDTO;
import com.even.user.entity.BsRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author even
 * @since 2019-01-14
 */
public interface BsRoleMapper extends BaseMapper<BsRole> {

    List<RoleDTO> findByUserId(@Param("ew") QueryWrapper queryWrapper);

}
