package com.even.common.result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2019/1/16 0016.
 *
 * @author even
 * 返回结果集类
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ApiModel(value = "返回结果集类",description = "系统响应code date message封装类")
public class Result<T> {
    /**
     * 状态码
     */
    @ApiModelProperty(value = "返回状态")
    private int status;
    /**
     * 消息
     */
    @ApiModelProperty(value = "返回消息")
    private String message;
    /**
     * 数据
     */
    @ApiModelProperty(value = "返回数据模型类")
    private T data;
}
