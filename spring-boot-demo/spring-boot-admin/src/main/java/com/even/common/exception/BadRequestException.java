package com.even.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Created by Administrator on 2019/1/15 0015.
 *
 * @author even
 * 自定义异常 code统一返回400
 */
@Getter
public class BadRequestException extends RuntimeException{
    private Integer status = HttpStatus.BAD_REQUEST.value();

    public BadRequestException(String msg){
        super(msg);
    }

    public BadRequestException(HttpStatus status,String msg){
        super(msg);
        this.status = status.value();
    }
}
