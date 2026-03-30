package com.jstudy.distributed_scheduler.config;

import com.jstudy.distributed_scheduler.batch.UserProcessor;
import com.jstudy.distributed_scheduler.batch.UserReader;
import com.jstudy.distributed_scheduler.batch.UserWriter;
import com.jstudy.distributed_scheduler.dto.TargetUser;
import com.jstudy.distributed_scheduler.dto.User;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfig {

    @Bean
    public Job userParseJob(
            JobRepository jobRepository,
            @Qualifier("userParseStep") Step userParseStep
    ) {
        return new JobBuilder("userParseJob", jobRepository)
                .start(userParseStep)
                .build();
    }

    @Bean
    public Step userParseStep(
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager,
            UserReader userReader,
            UserProcessor userProcessor,
            UserWriter userWriter
    ) {
        return new StepBuilder("userParseStep", jobRepository)
                .<User, TargetUser>chunk(3, transactionManager)
                .reader(userReader)
                .processor(userProcessor)
                .writer(userWriter)
                .build();
    }

}
