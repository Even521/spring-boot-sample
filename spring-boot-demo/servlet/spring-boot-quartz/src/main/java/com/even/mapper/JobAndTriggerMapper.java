package com.even.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.even.model.JobAndTrigger;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author even
 * @date 2019/7/9 0009
 * @describe
 */
public interface JobAndTriggerMapper extends BaseMapper<JobAndTrigger> {
    /**
     * 查询任务列表
     * @return
     */
    IPage<JobAndTrigger> getJobAndTriggerDetails(IPage<JobAndTrigger> page, @Param("ew") Wrapper<JobAndTrigger> queryWrapper);
}
