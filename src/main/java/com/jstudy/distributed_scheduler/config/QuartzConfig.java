package com.jstudy.distributed_scheduler.config;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.CronScheduleBuilder.cronSchedule;

import com.jstudy.distributed_scheduler.scheduler.QuartzJob;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail QuartzSchedulerDetail() {
        return newJob(QuartzJob.class)
                .withIdentity("quartzJob", "default")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger QuartzSchedulerTrigger(JobDetail QuartzSchedulerDetail) {
        return newTrigger()
                .forJob(QuartzSchedulerDetail)
                .withIdentity("quartzTrigger", "default")
                .withSchedule(cronSchedule("0 * * * * ?"))
                .build();
    }



}
