package com.even;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ConditionalOnClass({DefaultRedisLock.class, RedisTemplate.class, StringRedisTemplate.class})
@EnableConfigurationProperties(RedisLockProperty.class)
//@Import({RedisLockAspect.class, DefaultRedisLock.class})
public class RedisLockAutoConfiguration {
}
