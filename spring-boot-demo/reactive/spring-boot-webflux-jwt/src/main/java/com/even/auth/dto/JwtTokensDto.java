package com.even.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author even
 * @date 2021/1/28 0028 下午 15:35
 * @describe
 */
@Getter
@AllArgsConstructor
public class JwtTokensDto {
    private String accessToken;
    private String refreshToken;
}
