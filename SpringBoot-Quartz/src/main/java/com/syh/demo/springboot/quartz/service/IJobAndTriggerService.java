package com.syh.demo.springboot.quartz.service;

import com.github.pagehelper.PageInfo;
import com.syh.demo.springboot.quartz.entity.JobAndTrigger;

/**
 * IJobAndTriggerService
 *
 * @author HSY
 * @since 2020/06/01 23:19
 */

public interface IJobAndTriggerService {
    PageInfo<JobAndTrigger> getJobAndTriggerDetails(int pageNum, int pageSize);
}
