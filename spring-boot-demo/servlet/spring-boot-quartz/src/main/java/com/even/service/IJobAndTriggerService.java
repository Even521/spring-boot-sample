package com.even.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.even.model.JobAndTrigger;

/**
 * @author even
 * @date 2019/7/9 0009
 * @describe
 */
public interface IJobAndTriggerService {

    IPage<JobAndTrigger> getJobAndTriggerDetails(Integer pageNum, Integer pageSize);
}
