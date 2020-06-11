package com.syh.demo.springboot.quartz.controller;

import com.syh.demo.springboot.quartz.service.JobAndTriggerService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * JobController
 *
 * @author HSY
 * @since 2020/06/01 23:12
 */
@RestController
@RequestMapping(value = "/job")
@Api(tags = "定时任务 前端控制器")
@Slf4j
public class JobController
{

    private final JobAndTriggerService jobAndTriggerService;

    public JobController(JobAndTriggerService jobAndTriggerService) {
        this.jobAndTriggerService = jobAndTriggerService;
    }

    @PostMapping()
    public void addJob(@RequestParam(value = "jobClassName") String jobClassName,
                       @RequestParam(value = "jobGroupName") String jobGroupName,
                       @RequestParam(value = "cronExpression") String cronExpression) throws Exception {
        jobAndTriggerService.addJob(jobClassName, jobGroupName, cronExpression);
    }

    @PostMapping(value = "/pausejob")
    public void pauseJob(@RequestParam(value = "jobClassName") String jobClassName,
                         @RequestParam(value = "jobGroupName") String jobGroupName) throws Exception {
        jobAndTriggerService.jobPause(jobClassName, jobGroupName);
    }

    @PostMapping(value="/resumejob")
    public void resumeJob(@RequestParam(value = "jobClassName") String jobClassName,
                          @RequestParam(value = "jobGroupName")String jobGroupName) throws Exception {
        jobAndTriggerService.jobResume(jobClassName, jobGroupName);
    }

    @PostMapping(value = "/reschedulejob")
    public void rescheduleJob(@RequestParam(value = "jobClassName") String jobClassName,
                              @RequestParam(value = "jobGroupName") String jobGroupName,
                              @RequestParam(value = "cronExpression") String cronExpression) throws Exception {
        jobAndTriggerService.jobReschedule(jobClassName, jobGroupName, cronExpression);
    }

    @PostMapping(value = "/deletejob")
    public void deleteJob(@RequestParam(value = "jobClassName") String jobClassName,
                          @RequestParam(value = "jobGroupName") String jobGroupName) throws Exception {
        jobAndTriggerService.jobDelete(jobClassName, jobGroupName);
    }

    @GetMapping(value="/queryjob")
    public Map<String, Object> queryJob(@RequestParam(value = "pageNum") Integer pageNum,
                                        @RequestParam(value = "pageSize")Integer pageSize) {
        return jobAndTriggerService.getJobAndTriggerDetails(pageNum, pageSize);
    }
}
