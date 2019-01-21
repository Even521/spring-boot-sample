package com.even.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author even
 * @since 2019-01-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("BS_MENUS_ROLES")
public class BsMenusRoles implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("MENU_ID")
    private Integer menuId;

    @TableField("ROLE_ID")
    private Integer roleId;


}
