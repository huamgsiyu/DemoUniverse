package com.syh.demo.springboot.quartz.mapper;

import com.syh.demo.springboot.quartz.entity.JobAndTrigger;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * JobAndTriggerMapper
 *
 * @author HSY
 * @since 2020/06/01 23:16
 */
@Mapper
public interface JobAndTriggerMapper {
    /**
     * 获取任务和Cron表达式信息
     * @return  {@link List<JobAndTrigger>}
     */
    List<JobAndTrigger> getJobAndTriggerDetails();
}
