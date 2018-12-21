package com.even.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/12/20 0020.
 *
 * @author even
 */
@Configuration
@EnableConfigurationProperties({FastJsonProperties.class})
@ConditionalOnClass({JSON.class, HttpMessageConverter.class})
public class FastJsonAutoConfiguration {
    @Resource
    private FastJsonProperties fastJsonProperties;

    @Bean
    @ConditionalOnProperty(prefix = "spring.fastjson", name = "enabled", havingValue = "true", matchIfMissing = true)
    @ConditionalOnWebApplication
    public HttpMessageConverter<?> httpMessageConverter() {
        /**
         * FastJsonHttpMessageConverter转换类
         */
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        /*媒体类型*/
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastJsonProperties.getSupportedMediaTypes());
        /*配置*/
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonProperties.getConfig());
        return fastJsonHttpMessageConverter;
    }
}
