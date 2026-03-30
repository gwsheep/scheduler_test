package com.jstudy.distributed_scheduler.scheduler;

import com.jstudy.distributed_scheduler.service.BatchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserBatchJob extends QuartzJobBean {

    private final BatchService batchService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        try {
            Long id = batchService.runBatch();
            System.out.println("[Quarts-BatchJob] 실행 종료, id = " + id);
        } catch (Exception e) {
            throw new RuntimeException("[Quarts-BatchJob] 실행 실패, error = " + e);
        }

    }

}
