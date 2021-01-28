package com.even.auth.request;

import lombok.Getter;

/**
 * @author even
 * @date 2021/1/28 0028 下午 15:56
 * @describe
 */
@Getter
public class SignUpRequest {
    private String userId;
    private String password;
    private String email;
}
