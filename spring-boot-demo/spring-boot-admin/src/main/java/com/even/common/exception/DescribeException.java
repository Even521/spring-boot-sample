package com.even.common.exception;

import com.even.common.exception.eum.ExceptionEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @author even
 * Created by Administrator on 2018/8/29 0029.
 * 自定义异常描述
 */

public class DescribeException extends RuntimeException{
    @Setter
    @Getter
    private int code;

    public DescribeException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }
    public DescribeException(Integer code,String message) {
        super(message);
        this.code = code;
    }

}
