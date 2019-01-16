package com.even.common.exception.eum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public enum  ExceptionEnum {
    /**
     * 不能为null
     */
    NULL_ERROR(0,"不能为null"),
    /**
     * 系统内部错误，请联系管理员
     */
    UNKNOW_ERROR(500, "系统内部错误，请联系管理员"),

    /**
     * 权限不足
     */
    AccessDenied(401,"用户权限不足"),

    /**
     * 访问路径错误
     */
    URL_ERROR(404,"访问路径错误"),
    /**
     * 未查询到数据
     */
    NULL_DATA(152,"未查询到数据");
    /**
     * 状态码
     */
    @Setter
    @Getter
    private int code;
    /**
     * 信息
     */
    @Setter
    @Getter
    private String msg;




}
