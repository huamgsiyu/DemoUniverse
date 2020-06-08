package com.syh.demo.springboot.quartz.entity;

import lombok.Data;

import java.math.BigInteger;

/**
 * JobAndTrigger
 *
 * @author HSY
 * @since 2020/06/01 23:17
 */
@Data
public class JobAndTrigger {

    private String jobName;
    private String jobGroup;
    private String jobClassName;
    private String triggerName;
    private String triggerGroup;
    private BigInteger repeatInterval;
    private BigInteger timesTriggered;
    private String cronExpression;
    private String timeZoneId;
}

