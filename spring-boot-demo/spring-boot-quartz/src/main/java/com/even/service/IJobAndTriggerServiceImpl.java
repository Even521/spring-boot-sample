package com.even.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.even.mapper.JobAndTriggerMapper;
import com.even.model.JobAndTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author even
 * @date 2019/7/9 0009
 * @describe
 */
@Service
public class IJobAndTriggerServiceImpl implements IJobAndTriggerService {
    @Resource
    private JobAndTriggerMapper jobAndTriggerMapper;
    @Override
    public IPage<JobAndTrigger> getJobAndTriggerDetails(Integer pageNum, Integer pageSize) {
        return jobAndTriggerMapper.getJobAndTriggerDetails(new Page<>(pageNum,pageSize),new QueryWrapper<>());
    }
}
