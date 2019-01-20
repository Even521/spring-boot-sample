package com.even.user.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2019/1/17 0017.
 *
 * @author even
 */
@Data
@ToString
public class RoleDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 用户ID
     */
    private int userId;

    /**
     * 角色ID
     */
    private Integer id;

    /**
     * 角色名称
     */

    private String roleName;

    /**
     * 角色创建时间
     */

    private LocalDateTime createTime;

    /**
     * 角色备注
     */

    private String remark;
    /**
     * 角色权限
     */
    private List<PermissionDTO> permissions;
}
