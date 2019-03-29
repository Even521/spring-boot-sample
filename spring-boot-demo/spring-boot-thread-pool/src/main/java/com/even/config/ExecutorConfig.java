package com.even.config;

import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author even
 * @Date 2019/3/28 16:06
 * @Describe
 */
@Configuration
@EnableAsync
@Log
public class ExecutorConfig {
    /**
     * 核心线程数
     */
    @Value("${async.executor.thread.core_pool_size}")
    private int corePoolSize ;

    /**
     * 最大线程数
     */
    @Value("${async.executor.thread.max_pool_size}")
    private int maxPoolSize;

    /**
     * 队列最大长度
     */
    @Value("${async.executor.thread.queue_capacity}")
    private int queueCapacity ;
    @Value("${async.executor.thread.name.prefix}")
    private String namePrefix;

    /**
     * 线程池维护线程所允许的空闲时间
     */
    @Value("${async.executor.thread.keep_alive_seconds}")
    private int keepAliveSeconds ;

    @Bean
    public Executor asyncServiceExecutor() {
        log.info("asyncServiceExecutor 开始 ");
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(corePoolSize);
        threadPoolTaskExecutor.setMaxPoolSize(maxPoolSize);
        threadPoolTaskExecutor.setQueueCapacity(queueCapacity);
        threadPoolTaskExecutor.setKeepAliveSeconds(keepAliveSeconds);
        threadPoolTaskExecutor.setThreadNamePrefix("async-service-");
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }


}
