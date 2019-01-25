package com.even.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.even.system.dto.MenuDTO;
import com.even.system.dto.RoleDTO;
import com.even.system.entity.BsMenu;
import com.even.system.mapper.BsMenuMapper;
import com.even.system.mapstruct.MenuMapStruct;
import com.even.system.service.IBsMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author even
 * @since 2019-01-21
 */
@Service
public class BsMenuServiceImpl extends ServiceImpl<BsMenuMapper, BsMenu> implements IBsMenuService {


    @Override
    public List<MenuDTO> findByRoles(List<RoleDTO> list) {
        List<MenuDTO> menuDTOList=new ArrayList<>();
        QueryWrapper<RoleDTO> queryWrapper=new QueryWrapper<>();
        list.stream().forEach(i->{
            queryWrapper.eq("BS_MENUS_ROLES.id",i.getId())
                    .eq("BS_MENU.PID",0)
                    .orderByAsc("sort");
            menuDTOList.addAll(this.baseMapper.findByRoles(queryWrapper));
        });
        return menuDTOList;
    }


}
