package com.even.security;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * Created by Administrator on 2019/1/15 0015.
 *
 * @author even
 * 授权用户
 */
@Getter
@Setter
public class AuthorizationUser {
    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 重写toString方法
     * @return
     */
    @Override
    public String toString(){
      return "{username=" + username  + ", password= ******}";
    }
}
