package com.jstudy.distributed_scheduler.scheduler;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Slf4j
@Component
public class ShedlockScheduler {

//    @Scheduled(cron = "0 * * * * *")
//    @SchedulerLock(
//        name = "shedlock-sheduler", lockAtMostFor = "55s", lockAtLeastFor = "55s"
//    )
    public void run() throws InterruptedException {
        log.info("[Shedlock] work start - {}", LocalDateTime.now(ZoneId.of("Asia/Seoul")));
        Thread.sleep(5000);
        log.info("[Shedlock] work end - {}", LocalDateTime.now(ZoneId.of("Asia/Seoul")));
    }

}
