package com.even.system.dto;

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
    private Integer id;

    /**
     * 别名
     */
    private String alias;

    /**
     * 名字
     */
    private String permissionName;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 父ID
     */
    private Integer pid;
    /**
     * 递归
     */
    private List<PermissionDTO> children;

}
