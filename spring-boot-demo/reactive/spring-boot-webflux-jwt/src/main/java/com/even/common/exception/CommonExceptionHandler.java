package com.even.common.exception;

import com.even.common.repose.ErrorResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.support.WebExchangeBindException;

/**
 * @author even
 * @date 2021/1/28 0028 下午 15:00
 * @describe
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CommonExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleUnknownError(Exception exception) {
        //ToDo insert Error report module
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "9000", exception.getMessage());
    }

    @ExceptionHandler(WebExchangeBindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleWrongRequestBody() {
        return new ErrorResponse(HttpStatus.BAD_REQUEST, "9001", "Wrong Request Body");
    }

}
