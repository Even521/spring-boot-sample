package com.even.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.even.user.dto.RoleDTO;
import com.even.user.entity.BsRole;
import com.even.user.mapper.BsRoleMapper;
import com.even.user.service.IBsRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author even
 * @since 2019-01-14
 */
@Service
public class BsRoleServiceImpl extends ServiceImpl<BsRoleMapper, BsRole> implements IBsRoleService {

    @Override
    public List<RoleDTO> findByUserId(int userId) {
        return this.baseMapper.findByUserId(
                new QueryWrapper<RoleDTO>().eq("user_id",userId)
        );
    }
}
