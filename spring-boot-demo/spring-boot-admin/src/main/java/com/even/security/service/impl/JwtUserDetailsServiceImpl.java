package com.even.security.service.impl;

import com.even.common.validation.AssertUtil;
import com.even.security.JwtUser;
import com.even.system.dto.PermissionDTO;
import com.even.system.dto.RoleDTO;
import com.even.system.dto.UserDTO;
import com.even.system.entity.BsPermission;
import com.even.system.service.IBsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2019/1/15 0015.
 *
 * @author even
 * 实现UserDetailsService
 */
@Service("jwtUserDetailsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private IBsUserService iBsUserService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDTO userDTO =iBsUserService.findByUserName(s);
        AssertUtil.NotNull(userDTO,"用户不存在");

        return toUserDetails(userDTO);
    }

    /**
     * 转换UserDetails
     * @param userDTO
     * @return
     */
    public UserDetails toUserDetails(UserDTO userDTO){
        return JwtUser.builder()
                .userName(userDTO.getUserName())
                .id(userDTO.getId())
                .roles(this.toGrantedAuthority(userDTO.getRoleDTOS()))
                .avatar(userDTO.getAvatar())
                .email(userDTO.getEmail())
                .createTime(userDTO.getCreateTime())
                .passWord(userDTO.getPassWord())
                .updateTime(userDTO.getUpdateTime())
                .enabled(userDTO.getEnabled()==1?true:false)
                .build();
    }

    /**
     * 获取用户所有角色权限
     * @param roleDTOS
     * @return
     */
    private  List<GrantedAuthority> toGrantedAuthority(List<RoleDTO> roleDTOS){
       List<PermissionDTO> list=new ArrayList<>();
       for (RoleDTO roleDTO:roleDTOS){
        list.addAll(roleDTO.getPermissions());
       }

        return list.stream().map(permissionDTO ->
                new SimpleGrantedAuthority("ROLE_"+permissionDTO.getPermissionName())
        ).collect(Collectors.toList());


    }

}
