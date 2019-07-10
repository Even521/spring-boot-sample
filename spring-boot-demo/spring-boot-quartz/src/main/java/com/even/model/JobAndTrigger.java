package com.even.model;

import lombok.Data;

import java.math.BigInteger;

/**
 * @author even
 * @date 2019/7/9 0009
 * @describe
 */
@Data
public class JobAndTrigger {
    /**
     * 任务名称
     */
    private String JobName;
    /**
     * 任务所在组
     */
    private String  JobGroup;
    /**
     * 任务类名
     */
    private String  JobClassName;
    /**
     * 触发器名称
     */
    private String  TriggerName;
    /**
     * 触发器所在组
     */
    private String  TriggerGroup;
    private BigInteger  RepeatInterval;
    private BigInteger  TimesTriggered;
    /**
     * 表达式
     */
    private String  CronExpression;
    /**
     * 时区
     */
    private String  TimeZoneId;


}
