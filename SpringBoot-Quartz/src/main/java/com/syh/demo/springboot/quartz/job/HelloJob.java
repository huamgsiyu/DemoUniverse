package com.syh.demo.springboot.quartz.job;


import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * HelloJob
 *
 * @author HSY
 * @since 2020/06/01 23:09
 */
public class HelloJob implements BaseJob {

    private static Logger _log = LoggerFactory.getLogger(HelloJob.class);

    @Override
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        _log.error("Hello Job执行时间: " + new Date());

    }
}
