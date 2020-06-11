package com.syh.demo.springboot.quartz.service;

import java.util.Map;

/**
 * JobAndTriggerService
 *
 * @author HSY
 * @since 2020/06/11 13:37
 */
public interface JobAndTriggerService {

    /**
     * 增加
     * @param jobClassName  job类名
     * @param jobGroupName  job分组名
     * @param cronExpression    cron表达式
     * @throws Exception    异常
     */
    void addJob(String jobClassName, String jobGroupName, String cronExpression) throws Exception;

    /**
     * 暂停
     * @param jobClassName  job类名
     * @param jobGroupName  job分组名
     * @throws Exception    异常
     */
    void jobPause(String jobClassName, String jobGroupName) throws Exception;

    /**
     * 恢复
     * @param jobClassName  job类名
     * @param jobGroupName  job分组名
     * @throws Exception    异常
     */
    void jobResume(String jobClassName, String jobGroupName) throws Exception;

    /**
     * 增加
     * @param jobClassName  job类名
     * @param jobGroupName  job分组名
     * @param cronExpression    cron表达式
     * @throws Exception    异常
     */
    void jobReschedule(String jobClassName, String jobGroupName, String cronExpression) throws Exception;

    /**
     * 删除
     * @param jobClassName  job类名
     * @param jobGroupName  job分组名
     * @throws Exception    异常
     */
    void jobDelete(String jobClassName, String jobGroupName) throws Exception;

    /**
     * 查询
     * @param pageNum  页数
     * @param pageSize  页大小
     * @return {@link Map}
     */
    Map<String, Object> getJobAndTriggerDetails (Integer pageNum, Integer pageSize);
}
