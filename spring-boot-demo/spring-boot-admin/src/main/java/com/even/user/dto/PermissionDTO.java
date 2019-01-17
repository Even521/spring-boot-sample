package com.even.user.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Administrator on 2019/1/17 0017.
 *
 * @author even
 */
@Data
public class PermissionDTO implements Serializable {
    /**
     * 权限ID
     */
    @TableId("ID")
    private Integer id;

    /**
     * 别名
     */
    @TableField("ALIAS")
    private String alias;

    /**
     * 名字
     */
    @TableField("PERMISSION_NAME")
    private String permissionName;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    /**
     * 父ID
     */
    @TableField("PID")
    private Integer pid;
    /**
     * 递归
     */
    private List<PermissionDTO> children;

}
