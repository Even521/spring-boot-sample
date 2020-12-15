package com.even.config;

import com.even.bean.BsUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by Administrator on 2019/1/4 0004.
 *
 * @author even
 */
@Configuration
public class UserDetailServiceConfig implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println(this.getUser().getPassword());
        return new User(s,this.getUser().getPassword(),true,true,true,true,AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }

    /**
     * 模拟一个用户代替数据库数据
     * @return
     */
    private BsUser getUser(){
        BsUser bsUser= BsUser.builder()
                .password(this.passwordEncoder.encode("123456"))
                .build();
        return bsUser;
    }
}
