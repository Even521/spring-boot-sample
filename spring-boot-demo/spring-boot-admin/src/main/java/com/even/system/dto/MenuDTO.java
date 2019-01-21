package com.even.system.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Administrator on 2019/1/21 0021.
 *
 * @author even
 */
public class MenuDTO  {

    private Integer id;

    /**
     * 菜单名称
     */

    private String name;


    private String component;

    /**
     * 上级菜单ID
     */

    private Integer pid;

    /**
     * 排序
     */

    private Integer sort;


    private String icon;

    /**
     * 链接地址
     */
    private String path;

    /**
     * 是否外链
     */
    private Integer iFrame;

    /**
     * 创建日期
     */
    private LocalDateTime createTime;
    /**
     * 角色
     */
    private List<RoleDTO> roleDTOS;
    /**
     * 子菜单
     */
    private List<MenuDTO> children;
}
