package com.even.auth.exception.exceptions;

/**
 * @author even
 * @date 2021/1/28 0028 下午 15:32
 * @describe
 */
public class RefreshTokenExpiredException extends RuntimeException{
    public RefreshTokenExpiredException() {
        super("Refresh token is expired");
    }
}
