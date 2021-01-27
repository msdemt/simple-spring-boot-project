package org.msdemt.simple.quartz_demo.service;

public interface JobService {

    /**
     * 获取任务信息
     *
     * @param name
     * @param group
     * @return
     */
    String get(String name, String group);

    /**
     * 开始任务
     *
     * @param name
     * @param group
     * @param cron
     * @param clazz
     */
    void start(String name, String group, String cron, Class clazz);

    /**
     * 修改任务
     *
     * @param name
     * @param group
     * @param time
     * @return
     */
    boolean modify(String name, String group, String time);


    /**
     * 暂停
     *
     * @param name
     * @param group
     */
    void stop(String name, String group);

    /**
     * 暂停所有
     */
    void stopAll();

    /**
     * 恢复任务
     *
     * @param name
     * @param group
     */
    void resume(String name, String group);


    /**
     * 恢复所有
     */
    void resumeAll();

    /**
     * 删除任务
     *
     * @param name
     * @param group
     */
    void delete(String name, String group);
}
