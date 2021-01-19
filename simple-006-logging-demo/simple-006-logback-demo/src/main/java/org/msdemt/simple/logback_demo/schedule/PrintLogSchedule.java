package org.msdemt.simple.logback_demo.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableScheduling
public class PrintLogSchedule {

    @Scheduled(cron = "0/1 * * * * ?")
    public void printDebugLog(){
        log.debug("print debug log");
    }

    @Scheduled(cron = "0/2 * * * * ?")
    public void printInfoLog(){
        log.debug("print info log");
    }

    @Scheduled(cron = "0/3 * * * * ?")
    public void printWarnLog(){
        log.debug("print warn log");
    }

    @Scheduled(cron = "0/4 * * * * ?")
    public void printErrorLog(){
        log.debug("print error log");
    }
}
