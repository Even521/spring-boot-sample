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
     * @param phoneNumber 手机号
     * @param signName     阿里云短信签名
     * @param templateCode  阿里云短信模板code
     * @param templateParam json模板参数字符串
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
