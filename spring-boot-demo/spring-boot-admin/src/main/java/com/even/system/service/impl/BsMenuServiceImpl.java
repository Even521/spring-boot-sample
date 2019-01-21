package com.even.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.even.system.dto.MenuDTO;
import com.even.system.dto.RoleDTO;
import com.even.system.entity.BsMenu;
import com.even.system.mapper.BsMenuMapper;
import com.even.system.service.IBsMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
            queryWrapper.eq("id",i.getId()).orderByAsc("sort");
            menuDTOList.addAll(this.baseMapper.findByRoles(queryWrapper));
        });
        return menuDTOList;
    }

    @Override
    public List<Map<String, Object>> getMenuTree(List<MenuDTO> list) {
        List<Map<String,Object>> menus = new LinkedList<>();
        Map<String,Object> map = new HashMap<>();
        list.stream().forEach(l->{
            map.clear();
            map.put("id",l.getId());
            map.put("label",l.getName());
            List<BsMenu> menuList=this.baseMapper.selectList(new QueryWrapper<BsMenu>().eq("PID",l.getPid()));
           /* if(menuList!=null && menuList.size()!=0){
                map.put("children",this.getMenuTree(menuList));
            }
            list.add(map);*/
        });
        return null;
    }
}
