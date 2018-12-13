package com.sample.service;

import com.sample.timer.JobTimer;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by Administrator on 2018/12/3 0003.
 *
 * @author even
 */
@Service
public class JobTimerService {
    /**
     * 注入任务调度器
     */
    @Autowired
    private Scheduler scheduler;

    /**
     * 测试调用
     * @throws Exception
     */
    public void test() throws Exception {
        this.buildJobTimer();
    }

    public void buildJobTimer()throws Exception{
        //1.设置时间
        long startAtTime = System.currentTimeMillis() + 1000 * 60;
        //2.任务名称
        String name = UUID.randomUUID().toString();
        //3.任务所示分组
        String group = JobTimer.class.getName();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/30 * * * * ?");
        //4.创建任务
        JobDetail jobDetail = JobBuilder.newJob(JobTimer.class).withIdentity(name, group).build();
        //5.创建任务触发器
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(name, group).withSchedule(scheduleBuilder).build();
        //6.将触发器与任务绑定到调度器内
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
