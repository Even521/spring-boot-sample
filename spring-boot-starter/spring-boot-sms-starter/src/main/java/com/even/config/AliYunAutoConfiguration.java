package com.even.config;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.even.aliyun.properties.AliYunSmsProperties;
import com.even.aliyun.service.AliYunSmsService;
import com.even.aliyun.service.AliYunSmsServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author even
 * @date 2019/10/14 0014
 * @describe
 */
@Configuration
@EnableConfigurationProperties(value = AliYunSmsProperties.class)
@ConditionalOnProperty(prefix = AliYunSmsProperties.PREFIX, name = "enable", havingValue = "true")
public class AliYunAutoConfiguration {
    @Bean
    public AliYunSmsService aliYunSmsService(AliYunSmsProperties properties){
        return new AliYunSmsServiceImpl(properties);
    }

}
