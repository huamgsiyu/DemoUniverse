package com.syh.demo.springboot.quartz.dao;

import com.github.pagehelper.PageInfo;
import com.syh.demo.springboot.quartz.entity.JobAndTrigger;

import java.util.List;

/**
 * IJobAndTriggerService
 *
 * @author HSY
 * @since 2020/06/01 23:19
 */

public interface IJobAndTriggerService {

    /**
     * 获取任务和Cron表达式信息
     * @return  {@link PageInfo<JobAndTrigger>}
     */
    PageInfo<JobAndTrigger> getJobAndTriggerDetails(int pageNum, int pageSize);
}
