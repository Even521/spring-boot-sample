package com.even.system.service;

import com.even.system.dto.MenuDTO;
import com.even.system.dto.RoleDTO;
import com.even.system.entity.BsMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.even.system.entity.BsRole;

import javax.management.relation.Role;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author even
 * @since 2019-01-21
 */
public interface IBsMenuService extends IService<BsMenu> {
    /**
     * 查询用户所有角色所有菜单
     * @param list
     * @return
     */
    List<MenuDTO> findByRoles(List<RoleDTO> list);

    List<Map<String,Object>> getMenuTree(List<MenuDTO> list);


}
