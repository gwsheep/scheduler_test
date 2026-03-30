package com.jstudy.distributed_scheduler.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Slf4j
//@Component
public class QuartzJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String jobName = context.getJobDetail().getKey().getName();
        String jobGroup = context.getJobDetail().getKey().getGroup();
        log.info("[Quartz] work start - {}", LocalDateTime.now(ZoneId.of("Asia/Seoul")));
        log.info("[Quartz] jobName = {}, jobGroup = {}", jobName, jobGroup);
        log.info("[Quartz] work end - {}", LocalDateTime.now(ZoneId.of("Asia/Seoul")));
    }


}
