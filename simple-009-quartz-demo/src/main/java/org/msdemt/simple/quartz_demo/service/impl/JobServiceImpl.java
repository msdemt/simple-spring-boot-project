package org.msdemt.simple.quartz_demo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.msdemt.simple.quartz_demo.service.JobService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service("jobService")
public class JobServiceImpl implements JobService {

    /**
     * 任务调度
     */
    private Scheduler scheduler;

    /**
     * 使用构造器注入
     * QuartzServiceImpl强依赖scheduler，
     * 为了避免QuartzServiceImpl在Scheduler之前完成初始化，
     * 导致注入的Scheduler为null，所以使用构造器注入避免被注入的对象为null
     *
     * 使用构造器注入的效果是该类会在构造器参数里的对象初始化完成之后在运行本类构造器进行本类对象的初始化
     * @param scheduler
     */
    @Autowired
    public JobServiceImpl(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public String get(String name, String group) {
        try {
            TriggerKey triggerKey = new TriggerKey(name, group);
            CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            log.info(" job 【name=" + name + "】【group=" + group + "】 get");
            return String.format("time:%s,state:%s", cronTrigger.getCronExpression(),
                    scheduler.getTriggerState(triggerKey).name());
        } catch (SchedulerException schedulerException) {
            log.error("任务获取时异常", schedulerException);
        }
        return null;
    }

    @Override
    public void start(String name, String group, String cron, Class clazz) {
        try {
            // 通过JobBuilder构建JobDetail实例，JobDetail规定只能是实现Job接口的实例
            // JobDetail 是具体Job实例
            JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(name, group).build();
            // 基于表达式构建触发器
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
            // CronTrigger表达式触发器 继承于Trigger
            // TriggerBuilder 用于构建触发器实例
            CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(name, group)
                    .withSchedule(cronScheduleBuilder).build();
            scheduler.scheduleJob(jobDetail, cronTrigger);
            scheduler.start();
            log.info(" job 【name=" + name + "】【group=" + group + "】 has start ");
        } catch (SchedulerException schedulerException) {
            log.error("任务启动异常", schedulerException);
        }
    }

    @Override
    public boolean modify(String name, String group, String time) {
        Date date = null;
        try {
            TriggerKey triggerKey = new TriggerKey(name, group);
            CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            String oldTime = cronTrigger.getCronExpression();
            if (!oldTime.equalsIgnoreCase(time)) {
                CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(time);
                CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(name, group)
                        .withSchedule(cronScheduleBuilder).build();
                date = scheduler.rescheduleJob(triggerKey, trigger);
            }
            log.info(" job 【name=" + name + "】【group=" + group + "】 modify ");
        } catch (SchedulerException schedulerException) {
            log.error("任务更新异常", schedulerException);
        }
        return date != null;
    }

    @Override
    public void stop(String name, String group) {
        try {
            JobKey jobKey = new JobKey(name, group);
            JobDetail jobDetail = scheduler.getJobDetail(jobKey);
            if (jobDetail == null)
                return;
            scheduler.pauseJob(jobKey);
            log.info(" job 【name=" + name + "】【group=" + group + "】 is stop");
        } catch (SchedulerException schedulerException) {
            log.error("任务停止异常", schedulerException);
        }
    }

    @Override
    public void stopAll() {
        try {
            scheduler.pauseAll();
            log.info(" all job is stop");
        } catch (SchedulerException schedulerException) {
            log.error("停止全部任务时异常", schedulerException);

        }
    }

    @Override
    public void resume(String name, String group) {
        try {
            JobKey jobKey = new JobKey(name, group);
            JobDetail jobDetail = scheduler.getJobDetail(jobKey);
            if (jobDetail == null)
                return;
            scheduler.resumeJob(jobKey);
            log.info(" job 【name=" + name + "】【group=" + group + "】 is resume");
        } catch (SchedulerException schedulerException) {
            log.error("任务恢复时异常", schedulerException);

        }
    }

    @Override
    public void resumeAll() {
        try {
            scheduler.resumeAll();
            log.info(" all job is resume");
        } catch (SchedulerException schedulerException) {
            log.error("恢复所有任务时异常", schedulerException);
        }
    }

    @Override
    public void delete(String name, String group) {
        try {
            JobKey jobKey = new JobKey(name, group);
            JobDetail jobDetail = scheduler.getJobDetail(jobKey);
            if (jobDetail == null)
                return;
            scheduler.deleteJob(jobKey);
            log.info(" job 【name=" + name + "】【group=" + group + "】  has delete");
        } catch (SchedulerException schedulerException) {
            log.error("任务删除时异常", schedulerException);
        }
    }

}
