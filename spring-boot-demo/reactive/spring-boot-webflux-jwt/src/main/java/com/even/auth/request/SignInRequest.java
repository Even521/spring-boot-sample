package com.even.auth.request;

import lombok.Getter;

/**
 * @author even
 * @date 2021/1/28 0028 下午 15:52
 * @describe
 */
@Getter
public class SignInRequest {
    private String userId;
    private String password;
}
