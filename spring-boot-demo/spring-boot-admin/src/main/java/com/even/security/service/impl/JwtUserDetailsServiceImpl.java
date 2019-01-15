package com.even.security.service.impl;

import com.even.security.JwtUser;
import com.even.user.entity.BsUser;
import com.even.user.service.IBsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2019/1/15 0015.
 *
 * @author even
 * 实现UserDetailsService
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private IBsUserService iBsUserService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        BsUser bsUser=iBsUserService.findByName(s);
        if(bsUser==null){
            throw new UsernameNotFoundException("用户不存在");
        }
        return toUserDetails(bsUser);
    }

    /**
     * 转换UserDetails
     * @param bsUser
     * @return
     */
    public UserDetails toUserDetails(BsUser bsUser){
        return JwtUser.builder()
                .id(bsUser.getId())
                .authorities(null)
                .avatar(bsUser.getAvatar())
                .createTime(bsUser.getCreateTime())
                .email(bsUser.getEmail())
                .passWord(bsUser.getPassWord())
                .updateTime(bsUser.getUpdateTime())
                .enabled(bsUser.getEnabled()==1?true:false)
                .build();
    }
}
