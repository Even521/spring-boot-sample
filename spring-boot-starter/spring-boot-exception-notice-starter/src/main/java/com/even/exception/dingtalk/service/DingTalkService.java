package com.even.exception.dingtalk.service;

import com.even.exception.dingtalk.model.ExceptionInfo;

/**
 * @author even
 * @date 2019/8/28 0028
 * @describe
 * 钉钉异常信息通知接口
 */
public interface DingTalkService {
    void sendNotice(ExceptionInfo exceptionInfo);
}
