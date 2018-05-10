package cn.xyz.basic.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class CronTriggerRunner {
    public static void main(String[] args) {
        try {
            JobDetail jobDetail = new JobDetail("job_2","jGroup1",SimpleJob.class);

            //创建CronTrigger触发器，指定组合名称
            CronTrigger cronTrigger = new CronTrigger("trigger1_2","tgroup1");
            //定义Cron表达式
            CronExpression expression = new CronExpression("0/5 * * * * ?");
            //设置Cron表达式
            cronTrigger.setCronExpression(expression);

            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.scheduleJob(jobDetail,cronTrigger);
            scheduler.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
