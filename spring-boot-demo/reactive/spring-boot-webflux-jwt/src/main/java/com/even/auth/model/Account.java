package com.even.auth.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author even
 * @date 2021/1/28 0028 下午 15:06
 * @describe
 */
@Getter
@NoArgsConstructor
public class Account {

    private long accountId;
    private String userId;
    private String password;
    private String email;

    private UserStatus state;
    private String refreshToken;

    private List<UserRole> roles;

    public void updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Account(String userId, String password, String email, UserStatus state, List<UserRole> roles, String refreshToken) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.state = state;
        this.refreshToken = refreshToken;
        this.roles = roles;
    }
}
