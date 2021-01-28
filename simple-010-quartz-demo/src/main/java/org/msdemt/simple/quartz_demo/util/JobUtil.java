package org.msdemt.simple.quartz_demo.util;

import org.msdemt.simple.quartz_demo.service.JobService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class JobUtil {


    /**
     * JOB服务
     */
    private JobService jobService;

    @Autowired
    public JobUtil(JobService jobService) {
        this.jobService = jobService;
    }

    /**
     * 启动定时任务
     * @param name
     * @param group
     * @param cron
     * @param clazz
     */
    public void start(String name, String group, String cron, Class clazz) {
        Assert.notNull(name, "name is null");
        Assert.notNull(group, "group is null");
        Assert.notNull(cron, "cron is null");
        Assert.notNull(clazz, "clazz is null");
        jobService.start(name, group, cron, clazz);
    }

    /**
     * 任务更新
     *
     * @param name
     * @param group
     * @param time
     * @return
     * @throws SchedulerException
     */
    public boolean modify(String name, String group, String time) throws SchedulerException {
        Assert.notNull(name, "name is null");
        Assert.notNull(group, "group is null");
        Assert.notNull(time, "time is null");
        return jobService.modify(name, group, time);
    }

    /**
     * 任务停止
     *
     * @param name
     * @param group
     */
    public void stop(String name, String group) {
        Assert.notNull(name, "name is null");
        Assert.notNull(group, "group is null");
        jobService.stop(name, group);
    }

    /**
     * 停止所有任务
     */
    public void stopAll() {
        jobService.stopAll();
    }

    /**
     * 任务恢复
     *
     * @param name
     * @param group
     */
    public void resume(String name, String group) {
        Assert.notNull(name, "name is null");
        Assert.notNull(group, "group is null");
        jobService.resume(name, group);
    }

    /**
     * 恢复所有任务
     */
    public void resumeAll() {
        jobService.resumeAll();
    }

    /**
     * 任务删除
     *
     * @param name
     * @param group
     */
    public void delete(String name, String group) {
        Assert.notNull(name, "name is null");
        Assert.notNull(group, "group is null");
        jobService.delete(name, group);
    }

    /**
     * 获取任务信息
     *
     * @param name
     * @param group
     * @return
     */
    public String get(String name, String group) {
        Assert.notNull(name, "name is null");
        Assert.notNull(group, "group is null");
        return jobService.get(name, group);
    }
}
