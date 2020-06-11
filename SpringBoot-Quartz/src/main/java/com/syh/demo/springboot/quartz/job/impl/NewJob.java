package com.syh.demo.springboot.quartz.job.impl;

import com.syh.demo.springboot.quartz.job.BaseJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;

import java.util.Date;

/**
 * NewJob
 *
 * @author HSY
 * @since 2020/06/01 23:10
 */
@Slf4j
public class NewJob implements BaseJob {

    @Override
    public void execute(JobExecutionContext context) {
        log.info("New Job执行时间: " + new Date());

    }
}
