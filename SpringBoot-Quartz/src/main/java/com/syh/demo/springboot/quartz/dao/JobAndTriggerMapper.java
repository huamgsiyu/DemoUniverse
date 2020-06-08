package com.syh.demo.springboot.quartz.dao;

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
    List<JobAndTrigger> getJobAndTriggerDetails();
}
