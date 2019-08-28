package com.even.exception.dingtalk.model;

import lombok.Data;
import lombok.ToString;

/**
 * @author even
 * @date 2019/8/28 0028
 * @describe
 * 钉钉异常通知响应结果
 */
@Data
@ToString
public class DingTalkResult {
    /**
     * 错误code
     */
    private int errcode;
    /**
     * 错误消息
     */
    private String errmsg;

}
