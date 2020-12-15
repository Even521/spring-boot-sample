package com.even.jobs;

import com.even.service.BaseJob;
import lombok.extern.log4j.Log4j2;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;

/**
 * @author even
 * @date 2019/7/10 0010
 * @describe
 */
@Log4j2
public class HelloJob implements BaseJob {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("{}",LocalDateTime.now());
    }
}
