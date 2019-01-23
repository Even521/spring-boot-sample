package com.even.security.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.even.common.exception.DescribeException;
import com.even.common.exception.eum.ExceptionEnum;
import com.even.common.result.Result;
import com.even.common.result.ResultUtils;
import com.even.security.AuthenticationToken;
import com.even.security.AuthorizationUser;
import com.even.security.JwtUser;
import com.even.security.utils.EncryptUtils;
import com.even.security.utils.JwtTokenUtil;
import com.even.system.entity.BsUser;
import com.even.system.service.IBsUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.zip.DataFormatException;

/**
 * Created by Administrator on 2019/1/15 0015.
 *
 * @author even
 */
@RestController
@RequestMapping("auth")
@Log4j2
public class AuthenticationController {
    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Qualifier("jwtUserDetailsService")
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private IBsUserService iBsUserService;


    /**
     * 登录授权
     * @param authorizationUser
     * @return
     */
    @PostMapping(value = "${jwt.auth.path}")
    public Result<AuthenticationToken> authenticationLogin(@RequestBody AuthorizationUser authorizationUser) {
        final BsUser bsUser = iBsUserService.findByName(authorizationUser.getUsername());
        //判断密码
        if(!bsUser.getPassWord().equals(authorizationUser.getPassword())){
            throw new DescribeException(ExceptionEnum.NULL_ERROR.getCode(),"密码错误");
        }
        if(bsUser.getEnabled()==0?true:false){
            throw new DescribeException(ExceptionEnum.NULL_ERROR.getCode(),"账号已停用，请联系管理员");
        }

        // 生成令牌
        final String token = jwtTokenUtil.generateToken(bsUser.getUserName());

        // 返回 token
        return ResultUtils.success(new AuthenticationToken(token));
    }

    /**
     * 获取用户信息
     * @param request
     * @return
     */
    @GetMapping(value = "${jwt.auth.account}")
    public  Result<JwtUser> getUserInfo(HttpServletRequest request){

        JwtUser jwtUser= (JwtUser) userDetailsService.loadUserByUsername(jwtTokenUtil.getUserName(request));

        return ResultUtils.success(jwtUser);
    }
}
