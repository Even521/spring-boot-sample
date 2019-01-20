package com.even.user.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

import javax.management.relation.Role;
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
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String passWord;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 是否可用 1可用 0不可用
     */

    private Integer enabled;

    /**
     * 邮箱地址
     */

    private String email;
    /**
     * 创建时间
     */

    private LocalDateTime createTime;
    /**
     * 修改时间
     */

    private LocalDateTime updateTime;
    /**
     * 角色
     */
    private List<RoleDTO> roleDTOS;
}
