package com.even.auth.exception.exceptions;

/**
 * @author even
 * @date 2021/1/28 0028 下午 15:33
 * @describe
 */
public class InvalidTokenException extends RuntimeException{
    public InvalidTokenException() {
        super("Invalid token values");
    }
}
