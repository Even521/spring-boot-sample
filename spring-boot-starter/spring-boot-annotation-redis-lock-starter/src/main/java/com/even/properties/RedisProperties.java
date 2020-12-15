package com.even.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author even
 * @date 2019/9/23 0023
 * @describe
 */
@Data
@ConfigurationProperties(value = "spring.redis")
public class RedisProperties {
    @Value("${database}")
    private Integer database;
    @Value("${host}")
    private String host;
    @Value("${port}")
    private Integer port;
    @Value("${password}")
    private String password;

}
