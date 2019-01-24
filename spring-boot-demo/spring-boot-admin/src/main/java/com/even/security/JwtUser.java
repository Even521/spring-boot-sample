package com.even.security;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by Administrator on 2019/1/15 0015.
 *
 * @author even
 * 实现用户信息
 */
@Getter
@AllArgsConstructor
@Builder
public class JwtUser implements UserDetails {
    /**
     * ID
     */
    private final int id;
    /**
     * 用户名
     */
    private final String userName;
    /**
     * 密码
     */
    @JSONField(serialize=false)
    private final String passWord;
    /**
     * 头像
     */
    private final String avatar;
    /**
     * 邮箱
     */
    private final String email;
    /**
     * 是否可用
     */
    private final boolean enabled;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
    /**
     * 权限
     */
    @JSONField(serialize = false)
    private final Collection<? extends GrantedAuthority> authorities;



    @Override
    public String getPassword() {
        return passWord;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * 在我们保存权限的时候加上了前缀ROLE_，因此在这里需要处理下数据
     * @return
     */
    public Collection getRoles() {
        List<String> roles = new LinkedList<>();
        for (GrantedAuthority authority : authorities) {
            roles.add(authority.getAuthority().substring(5));
        }
        return roles;
    }
}
