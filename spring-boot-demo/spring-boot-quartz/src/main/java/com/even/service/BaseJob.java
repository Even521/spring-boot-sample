package com.even.service;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author even
 * @date 2019/7/9 0009
 * @describe
 */
public interface BaseJob extends Job {
    void execute(JobExecutionContext context) throws JobExecutionException;
}
