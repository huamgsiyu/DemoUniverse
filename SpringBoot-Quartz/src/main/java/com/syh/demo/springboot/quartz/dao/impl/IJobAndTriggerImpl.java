package com.syh.demo.springboot.quartz.dao.impl;


import java.util.List;

import com.github.pagehelper.PageInfo;
import com.syh.demo.springboot.quartz.mapper.JobAndTriggerMapper;
import com.syh.demo.springboot.quartz.entity.JobAndTrigger;
import com.syh.demo.springboot.quartz.dao.IJobAndTriggerService;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

/**
 * JobAndTriggerImpl
 *
 * @author HSY
 * @since 2020/06/01 23:20
 */
@Service
public class IJobAndTriggerImpl implements IJobAndTriggerService {

    private final JobAndTriggerMapper jobAndTriggerMapper;

    public IJobAndTriggerImpl(JobAndTriggerMapper jobAndTriggerMapper) {
        this.jobAndTriggerMapper = jobAndTriggerMapper;
    }

    @Override
    public PageInfo<JobAndTrigger> getJobAndTriggerDetails(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<JobAndTrigger> list = jobAndTriggerMapper.getJobAndTriggerDetails();
        return new PageInfo<>(list);
    }
}
