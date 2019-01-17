package com.even.user.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by Administrator on 2019/1/17 0017.
 *
 * @author even
 */
@Data
public class RoleDTO {
    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @TableId("ID")
    private Integer id;

    /**
     * 角色名称
     */
    @TableField("ROLE_NAME")
    private String roleName;

    /**
     * 角色创建时间
     */
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    /**
     * 角色备注
     */
    @TableField("REMARK")
    private String remark;
    /**
     * 角色权限
     */
    private Set<PermissionDTO> permissions;
}
