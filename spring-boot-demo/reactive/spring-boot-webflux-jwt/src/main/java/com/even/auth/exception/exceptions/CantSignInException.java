package com.even.auth.exception.exceptions;

/**
 * @author even
 * @date 2021/1/28 0028 下午 15:28
 * @describe
 */
public class CantSignInException extends RuntimeException {
    public CantSignInException() {
        super("Sign-in Failed");
    }
}
