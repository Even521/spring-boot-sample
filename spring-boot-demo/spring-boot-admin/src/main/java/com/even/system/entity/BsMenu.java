package com.even.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜单
 * </p>
 *
 * @author even
 * @since 2019-01-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("BS_MENU")
public class BsMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 菜单名称
     */
    @TableField("NAME")
    private String name;

    @TableField("COMPONENT")
    private String component;

    /**
     * 上级菜单ID
     */
    @TableField("PID")
    private Integer pid;

    /**
     * 排序
     */
    @TableField("SORT")
    private Integer sort;

    @TableField("ICON")
    private String icon;

    /**
     * 链接地址
     */
    @TableField("PATH")
    private String path;

    /**
     * 是否外链
     */
    @TableField("I_FRAME")
    private Integer iFrame;

    /**
     * 创建日期
     */
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;


}
