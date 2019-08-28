package com.even.exception.dingtalk.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author even
 * @date 2019/8/27 0027
 * @describe
 * 异常通知yml配置
 */
@Data
@ConfigurationProperties(prefix=ExceptionNoticeProperties.PREFIX )
public class ExceptionNoticeProperties {
    /**
     *配置文件前缀
     */
    public static final String PREFIX="exception.notice.ding.talk";
    /**
     * 异常信息发送的时间周期 以秒为单位 默认3s
     */
    private Long period=3L;
    /**
     * 是否启用
     */
    private boolean enable;
    /**
     * 异常项目名
     */
    @Value("${spring.application.name:${exception.project-name:无名工程}}")
    private String projectName;

    /**
     * 追踪信息的包含的包名
     */
    private String includedTracePackage;
    /**
     * 排除的需要统计的异常
     */
    private List<Class<? extends Exception>> excludeExceptions = new ArrayList<>();

    /**
     * 钉钉通知配置
     */
    @NestedConfigurationProperty
    private DingTalkProperties dingTalk;

}
