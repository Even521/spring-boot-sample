package com.even.service;

import com.even.utils.ListUtils;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author even
 * @Date 2019/4/1 17:40
 * @Describe
 */
@Service
@Log4j2
public class AsyncServiceImpl implements AsyncService{
    @Resource(name="asyncServiceExecutor")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    /**
     * 打印日志
     * @param
     */
    @Override
    public void  printInLog(){
        log.info("{},taskCount [{}], completedTaskCount [{}], activeCount [{}], queueSize [{}]",
                threadPoolTaskExecutor.getThreadNamePrefix(),
                threadPoolTaskExecutor.getThreadPoolExecutor().getTaskCount(),
                threadPoolTaskExecutor.getThreadPoolExecutor().getCompletedTaskCount(),
                threadPoolTaskExecutor.getThreadPoolExecutor().getActiveCount(),
                threadPoolTaskExecutor.getThreadPoolExecutor().getQueue().size());
    }


    private void toDo(int i){
        log.error(" hello-{}",i);
    }

    @Override
    public void asyncRequest(List<Integer> list) {
        List<List<Integer>> lists= ListUtils.averageAssign(list,5);
        lists.forEach(
                l -> {
                    threadPoolTaskExecutor.execute(() ->
                               l.forEach(
                                   i -> this.toDo(i) )
                    );
                }

        );
    }



}
