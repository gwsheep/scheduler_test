package com.jstudy.distributed_scheduler.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class BatchService {

    private final JobLauncher jobLauncher;
    private final Job userParseJob;

    public BatchService(JobLauncher jobLauncher,
                        @Qualifier("userParseJob") Job userParseJob) {
        this.jobLauncher = jobLauncher;
        this.userParseJob = userParseJob;
    }

    public Long runBatch() {

        JobParameters jobParameters = new JobParameters(
                Map.of("requestTime", new JobParameter<>(System.currentTimeMillis(), Long.class)));

        try {
            JobExecution jobExecution = jobLauncher.run(userParseJob, jobParameters);
            return jobExecution.getId();
        } catch (Exception e) {
            throw new RuntimeException("Batch 실행 실패 = " + e.getMessage());
        }


    }


}
