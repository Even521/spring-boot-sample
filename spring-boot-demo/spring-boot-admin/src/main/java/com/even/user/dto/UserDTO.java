package com.even.user.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.management.relation.Role;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by Administrator on 2019/1/17 0017.
 *
 * @author even
 */
@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @TableField("USER_NAME")
    private String userName;

    /**
     * 密码
     */
    @TableField("PASS_WORD")
    private String passWord;

    /**
     * 头像
     */
    @TableField("AVATAR")
    private String avatar;

    /**
     * 是否可用 1可用 0不可用
     */
    @TableField("ENABLED")
    private Integer enabled;

    /**
     * 邮箱地址
     */
    @TableField("EMAIL")
    private String email;
    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;
    /**
     * 角色
     */
    private Set<RoleDTO> roleDTOS;
}
