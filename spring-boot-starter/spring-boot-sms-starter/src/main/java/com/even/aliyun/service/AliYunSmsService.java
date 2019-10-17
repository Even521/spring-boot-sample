package com.even.aliyun.service;

import com.aliyuncs.exceptions.ClientException;
import org.springframework.lang.NonNull;

/**
 * @author even
 * @date 2019/10/15 0015
 * @describe
 * 阿里云短信服务
 */
public interface AliYunSmsService {
    /**
     * 阿里云发送短消息
     * @param phoneNumber
     * @param signName
     * @param templateCode
     * @param templateParam
     * @return
     */
    boolean sendSms(@NonNull String phoneNumber,@NonNull String signName,
                    @NonNull String templateCode,@NonNull String templateParam);

    /**
     * 获取验证码随机数
     * @param digits 几位验证码数
     * @return
     */
    String getRandCode(int digits);
}
