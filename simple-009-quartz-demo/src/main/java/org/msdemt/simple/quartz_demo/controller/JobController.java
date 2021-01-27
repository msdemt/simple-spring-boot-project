package org.msdemt.simple.quartz_demo.controller;

import org.msdemt.simple.quartz_demo.job.HelloJob;
import org.msdemt.simple.quartz_demo.job.InfoJob;
import org.msdemt.simple.quartz_demo.job.PrintJob;
import org.msdemt.simple.quartz_demo.util.JobUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/job")
@RestController
public class JobController {
    
    private JobUtil jobUtil;

    @Autowired
    public JobController(JobUtil jobUtil) {
        this.jobUtil = jobUtil;
    }

    @RequestMapping(value = "startJob",method = {RequestMethod.POST,RequestMethod.GET})
    public void startJob(){
        String name = "hyh-name", group = "default-group", cron = "*/5 * * * * ?";
        jobUtil.start("job", group, cron, PrintJob.class);
        jobUtil.start("hello", group, cron, HelloJob.class);
        jobUtil.start("info", "info", cron, InfoJob.class);
    }

    @RequestMapping(value = "deleteJob",method = {RequestMethod.POST,RequestMethod.GET})
    public void deleteJob(){
        String name = "hyh-name", group = "hyh-group", cron = "*/5 * * * * ?";
        jobUtil.delete(name, group);
    }
}
