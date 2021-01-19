package org.msdemt.simple.logback_demo.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableScheduling
public class PrintLogSchedule {

    @Scheduled(cron = "0/5 * * * * ?")
    public void printDebugLog() {
        //log.debug("user.dir:" + System.getProperty("user.dir"));
        log.debug("print debug log");
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void printInfoLog() {
        //log.info("user.home:" + System.getProperty("user.home"));
        log.info("print info log");
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void printWarnLog() {
        log.warn("print warn log");
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void printErrorLog() {
        //log.error("user.name:" + System.getProperty("user.name"));
        log.error("print error log");
    }
}
