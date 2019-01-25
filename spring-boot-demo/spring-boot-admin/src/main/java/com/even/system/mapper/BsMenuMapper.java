package com.even.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.even.system.dto.MenuDTO;
import com.even.system.entity.BsMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author even
 * @since 2019-01-21
 */
public interface BsMenuMapper extends BaseMapper<BsMenu> {
   /**
    * 查询菜单
    * @param queryWrapper
    * @return
    */
   List<MenuDTO>  findByRoles(@Param("ew")QueryWrapper queryWrapper);

   /**
    * 查询子菜单
    * @param id
    * @return
    */
   List<MenuDTO> findByRoleId(@Param("id") int id);
}
