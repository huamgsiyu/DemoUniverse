package com.syh.demo.springboot.quartz.service.impl;


import java.util.List;

import com.github.pagehelper.PageInfo;
import com.syh.demo.springboot.quartz.dao.JobAndTriggerMapper;
import com.syh.demo.springboot.quartz.entity.JobAndTrigger;
import com.syh.demo.springboot.quartz.service.IJobAndTriggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

/**
 * JobAndTriggerImpl
 *
 * @author HSY
 * @since 2020/06/01 23:20
 */
@Service
public class JobAndTriggerImpl implements IJobAndTriggerService {

    @Autowired
    private JobAndTriggerMapper jobAndTriggerMapper;

    @Override
    public PageInfo<JobAndTrigger> getJobAndTriggerDetails(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<JobAndTrigger> list = jobAndTriggerMapper.getJobAndTriggerDetails();
        PageInfo<JobAndTrigger> page = new PageInfo<JobAndTrigger>(list);
        return page;
    }

}
