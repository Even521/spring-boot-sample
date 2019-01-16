package com.even.security;

import com.even.common.exception.eum.ExceptionEnum;
import com.even.common.result.ResultUtils;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;


/**
 * Created by Administrator on 2019/1/15 0015.
 *
 * @author even
 * AuthenticationEntryPoint 用来解决匿名用户访问无权限资源时的异常
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException authException) throws IOException, ServletException {
        /**
         * 当用户尝试访问安全的REST资源而不提供任何凭据时，将调用此方法发送401 响应
         */
       // httpServletResponse.setStatus(401);
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        PrintWriter writer =httpServletResponse.getWriter();
        writer.write(ResultUtils.error(ExceptionEnum.AccessDenied).toString());
        //httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException==null?"Unauthorized":authException.getMessage());
    }
}
