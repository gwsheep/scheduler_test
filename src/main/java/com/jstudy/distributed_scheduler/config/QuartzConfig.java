package com.jstudy.distributed_scheduler.config;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.CronScheduleBuilder.cronSchedule;

import com.jstudy.distributed_scheduler.scheduler.QuartzJob;
import com.jstudy.distributed_scheduler.scheduler.UserBatchJob;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail quartzUserBatchJobDetail() {
        return newJob(UserBatchJob.class)
                .withIdentity("userBatchJob", "batch")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger quartzUserBatchTrigger(JobDetail quartzUserBatchJobDetail) {
        return newTrigger()
                .forJob(quartzUserBatchJobDetail)
                .withIdentity("userBatchTrigger", "batch")
                .withSchedule(cronSchedule("0 * * * * ?"))
                .build();
    }

    //순수 Quartz Test 용도
//    @Bean
//    public JobDetail QuartzSchedulerDetail() {
//        return newJob(QuartzJob.class)
//                .withIdentity("quartzJob", "default")
//                .storeDurably()
//                .build();
//    }

    //순수 Quartz Test 용도
//    @Bean
//    public Trigger QuartzSchedulerTrigger(JobDetail QuartzSchedulerDetail) {
//        return newTrigger()
//                .forJob(QuartzSchedulerDetail)
//                .withIdentity("quartzTrigger", "default")
//                .withSchedule(cronSchedule("0 * * * * ?"))
//                .build();
//    }



}
