package com.syh.demo.springboot.quartz.job;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * NewJob
 *
 * @author HSY
 * @since 2020/06/01 23:10
 */
public class NewJob implements BaseJob {

    private static Logger _log = LoggerFactory.getLogger(NewJob.class);

    @Override
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        _log.error("New Job执行时间: " + new Date());

    }
}
