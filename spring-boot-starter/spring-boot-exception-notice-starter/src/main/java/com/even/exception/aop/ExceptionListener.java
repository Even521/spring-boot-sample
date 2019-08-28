package com.even.exception.aop;

import com.even.exception.dingtalk.handler.ExceptionNoticeHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author even
 * @date 2019/8/28 0028
 * @describe
 * 异常捕获切面
 */
@RequiredArgsConstructor
@Aspect
public class ExceptionListener {

    private final ExceptionNoticeHandler handler;

    @AfterThrowing(value = "@within(org.springframework.web.bind.annotation.RestController) || @within(org.springframework.stereotype.Controller)", throwing = "e")
    public void doAfterThrow(JoinPoint joinPoint, Exception e) {
        handler.createNotice(e, joinPoint);
    }
}
