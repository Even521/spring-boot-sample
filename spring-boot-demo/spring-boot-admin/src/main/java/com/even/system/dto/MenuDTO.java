package com.even.system.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Administrator on 2019/1/21 0021.
 *
 * @author even
 */
@Data
public class MenuDTO implements Serializable {

    private Meta meta;

    @JSONField(serialize = false)
    private Integer id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 组件名称
     */
    private String component;

    /**
     * 上级菜单ID
     */
    @JSONField(serialize = false)
    private Integer pid;

    /**
     * 排序
     */
    @JSONField(serialize = false)
    private Integer sort;

    /**
     * 图标
     */
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
    @JSONField(serialize = false)
    private LocalDateTime createTime;
    /**
     * 子菜单
     */
    private List<MenuDTO> children;
    /**
     *
     */
    private boolean alwaysShow=true;

    private String redirect="noredirect";
}
