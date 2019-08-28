package com.even.exception.dingtalk.properties;

import lombok.Data;

/**
 * @author even
 * @date 2019/8/27 0027
 * @describe
 * 钉钉机器人配置
 */
@Data
public class DingTalkProperties {
    /**
     * 发送消息时被@钉钉用户手机号
     */
    private String[] atPhones;
    /**
     * 钉钉机器人webHook地址
     */
    private String webHook;
}
