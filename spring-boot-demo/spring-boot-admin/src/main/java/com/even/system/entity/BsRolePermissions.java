package com.even.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色权限中间表
 * </p>
 *
 * @author even
 * @since 2019-01-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("BS_ROLE_PERMISSIONS")
public class BsRolePermissions implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private Integer id;

    /**
     * 角色ID
     */
    @TableField("ROLE_ID")
    private Integer roleId;

    /**
     * 权限ID
     */
    @TableField("PERMISSION_ID")
    private Integer permissionId;


}
