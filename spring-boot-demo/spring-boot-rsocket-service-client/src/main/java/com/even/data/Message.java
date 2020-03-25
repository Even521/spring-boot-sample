package com.even.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * @author even
 * @date 2020/3/25 0025
 * @describe
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    /**
     * 来源
     */
    private String origin;
    /**
     * 消息传递样式
     */
    private String interaction;
    /**
     * 序列号
     */
    private long index;
    /**
     * 创建时间
     */
    private long created = Instant.now().getEpochSecond();

    public Message(String origin, String interaction) {
        this.origin = origin;
        this.interaction = interaction;
        this.index = 0;
    }

    public Message(String origin, String interaction, long index) {
        this.origin = origin;
        this.interaction = interaction;
        this.index = index;
    }
}
