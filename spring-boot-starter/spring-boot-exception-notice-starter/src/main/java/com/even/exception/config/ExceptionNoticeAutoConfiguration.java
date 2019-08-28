package com.even.exception.config;

import com.even.exception.aop.ExceptionListener;
import com.even.exception.dingtalk.handler.ExceptionNoticeHandler;
import com.even.exception.dingtalk.properties.DingTalkProperties;
import com.even.exception.dingtalk.properties.ExceptionNoticeProperties;
import com.even.exception.dingtalk.service.DingTalkService;
import com.even.exception.dingtalk.service.impl.DingTalkServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author even
 * @date 2019/8/27 0027
 * @describe
 * 异常信息配置类
 */
@Configuration
@ConditionalOnProperty(prefix = ExceptionNoticeProperties.PREFIX, name = "enable", havingValue = "true")
@EnableConfigurationProperties(value = ExceptionNoticeProperties.class)
public class ExceptionNoticeAutoConfiguration {
    private final RestTemplate restTemplate = new RestTemplate();

    @Bean(initMethod = "start")
    public ExceptionNoticeHandler noticeHandler(ExceptionNoticeProperties properties) {
        DingTalkProperties dingTalkProperties = properties.getDingTalk();
        DingTalkService noticeProcessor = null;
        if (null != dingTalkProperties) {
            noticeProcessor = new DingTalkServiceImpl(dingTalkProperties,restTemplate);
        }
        if (null == noticeProcessor) {
            throw new IllegalArgumentException("Exception notification configuration is incorrect");
        }
        return new ExceptionNoticeHandler(properties, noticeProcessor);
    }

    @Bean
    @ConditionalOnBean(ExceptionNoticeHandler.class)
    public ExceptionListener exceptionListener(ExceptionNoticeHandler noticeHandler) {
        return new ExceptionListener(noticeHandler);
    }
}
