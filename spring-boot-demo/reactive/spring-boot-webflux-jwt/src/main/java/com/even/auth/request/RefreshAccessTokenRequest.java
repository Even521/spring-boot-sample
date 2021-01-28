package com.even.auth.request;

import lombok.Getter;

/**
 * @author even
 * @date 2021/1/28 0028 下午 15:57
 * @describe
 */
@Getter
public class RefreshAccessTokenRequest {

    private String accessToken;

    private String refreshToken;
}
