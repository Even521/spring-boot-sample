package com.even.fastjson;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("redis-lock")
public class RedisLockProperty {
    private String defaultError = "The lock has been occupied.";

    private String liveTime = "90000";

    private String timeout = "500";

    private String prefix = "REDIS_LOCK_";
}
