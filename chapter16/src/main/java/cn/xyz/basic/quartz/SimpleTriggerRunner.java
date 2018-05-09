package cn.xyz.basic.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class SimpleTriggerRunner {
    public static void main(String[] args) throws SchedulerException {
        try {
            JobDetail jobDetail = new JobDetail("job_1","jgroup1",SimpleJob.class);
            SimpleTrigger simpleTrigger = new SimpleTrigger("trigger1_1","tgroup1");
            simpleTrigger.setStartTime(new Date());
            simpleTrigger.setRepeatInterval(2000);
            simpleTrigger.setRepeatCount(100);

            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.scheduleJob(jobDetail,simpleTrigger);
            scheduler.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
