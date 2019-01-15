package com.even.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/1/15 0015.
 *
 * @author even
 * 认证token
 */
@Getter
@AllArgsConstructor
public class AuthenticationToken implements Serializable {
    /**
     * token
     */
    private final String token;
}
