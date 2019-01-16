package com.even.common.exception.handler;

import com.even.common.exception.DescribeException;
import com.even.common.exception.eum.ExceptionEnum;
import com.even.common.result.Result;
import com.even.common.result.ResultUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 *
 */
@Log4j2
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public static Result exception(Exception e){
        log.info(e.getMessage());
        return ResultUtils.error(ExceptionEnum.UNKNOW_ERROR);
    }


    /**
     * 处理自定义描述异常
     * @param e
     * @return
     */
    @ExceptionHandler(DescribeException.class)
    public Result handleException(DescribeException e){
        // 打印堆栈信息
        log.error(e.getMessage());
        return ResultUtils.error(e.getCode(),e.getMessage());
    }
    /**
     * 处理 接口无权访问异常AccessDeniedException
     * @param e
     * @return
     */
    @ExceptionHandler(AccessDeniedException.class)
    public Result handleAccessDeniedException(AccessDeniedException e){
        // 打印堆栈信息
        log.error(e.getMessage());

        return ResultUtils.error(ExceptionEnum.AccessDenied);
    }

    /**
     * 处理所有接口数据验证异常
     * @param e
     * @returns
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        // 打印堆栈信息
        log.error(e.getMessage());
        String[] str = e.getBindingResult().getAllErrors().get(0).getCodes()[1].split("\\.");
        StringBuffer msg = new StringBuffer(str[1]+":");
        msg.append(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return  ResultUtils.error(301,msg.toString()+"参数错误");
    }

    /**
     * 处理404错误
     * @param e
     * @return
     */
    @ExceptionHandler(value = NoHandlerFoundException.class)
    public static Result noHandlerFoundException(NoHandlerFoundException e){
        log.error(e.getMessage());
        return ResultUtils.error(ExceptionEnum.URL_ERROR);
    }


}
