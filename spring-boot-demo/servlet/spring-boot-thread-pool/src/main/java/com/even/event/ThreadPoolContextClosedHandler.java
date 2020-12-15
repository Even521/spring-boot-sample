package com.even.event;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author even
 * @Date 2019/4/1 14:12
 * @Describe
 */
@Component
@Log4j2
public class ThreadPoolContextClosedHandler implements ApplicationListener<ContextClosedEvent> {


    @Override
    public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
       // showTheadPool( asyncServiceExecutor);

    }
    private void showTheadPool(ThreadPoolTaskExecutor threadPoolExecutor){
        if(null==threadPoolExecutor){
            return;
        }
        ThreadPoolExecutor threadPool= threadPoolExecutor.getThreadPoolExecutor();
        log.info("{},taskCount [{}], completedTaskCount [{}], activeCount [{}], queueSize [{}]",
                threadPoolExecutor.getThreadNamePrefix(),
                threadPool.getTaskCount(),
                threadPool.getCompletedTaskCount(),
                threadPool.getActiveCount(),
                threadPool.getQueue().size());

    }
}
