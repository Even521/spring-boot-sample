package com.even.exception.dingtalk.model;

import lombok.Data;

/**
 * @author even
 * @date 2019/8/28 0028
 * @describe
 */
@Data
public class DingTalkExceptionInfo {
    /**
     * 消息体
     */
    private DingDingText text;
    /**
     * at手机
     */
    private DingDingAt at;
    /**
     * 消息类型
     */
    private String msgtype = "text";

    public DingTalkExceptionInfo(String text, String... at) {
        this.text = new DingDingText(text);
        this.at = new DingDingAt(at);
    }

    @Data
    static class DingDingText {

        private String content;

        DingDingText(String content) {
            this.content = content;
        }

    }

    @Data
    static class DingDingAt {

        private String[] atMobiles;

        private boolean isAtAll = false;

        DingDingAt(String... atMobiles) {
            this.atMobiles = atMobiles;
        }

    }
}
