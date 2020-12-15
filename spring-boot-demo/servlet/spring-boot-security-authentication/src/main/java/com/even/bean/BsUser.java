package com.even.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2019/1/4 0004.
 *
 * @author even
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BsUser {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 账号是否过期
     */
    private boolean accountNonExpired;
    /**
     * 账号是否被锁
     */
    private boolean accountNonLocked;
    /**
     * 凭证是否过期
     */
    private boolean credentialsNonExpired;

    /**
     * 用户可用
     */
    private boolean enabled;
}
