package com.syh.demo.springboot.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * BaseJob
 *
 * @author HSY
 * @since 2020/06/01 23:09
 */
public interface BaseJob extends Job{

    @Override
    void execute(JobExecutionContext context) throws JobExecutionException;
}
