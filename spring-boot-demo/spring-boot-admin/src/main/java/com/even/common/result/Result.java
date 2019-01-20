package com.even.common.result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

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
public class Result<T> implements Serializable {
    /**
     * 状态码
     */
    @ApiModelProperty(value = "返回状态")
    private int code;
    /**
     * 消息
     */
    @ApiModelProperty(value = "返回消息")
    @NotNull
    private String message;
    /**
     * 数据
     */
    @ApiModelProperty(value = "返回数据模型类")
    private T data;

    /**
     * 重写toString方法
     * @return
     */
    @Override
    public String toString() {
        return "{code:" + this.getCode() + ", data:" + this.getData() + ", msg:" + this.getMessage() + "}";
    }

}
