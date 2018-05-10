package cn.xyz.basic.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class SimpleTriggerRunner {
    public static void main(String[] args) throws SchedulerException {
        try {
            //创建一个JobDetail实例，指定SimpleJob
            JobDetail jobDetail = new JobDetail("job_1","jgroup1",SimpleJob.class);
            //通过SimpleTrigger定义调度规则，马上启动、每隔2秒运行一次、执行100次
            SimpleTrigger simpleTrigger = new SimpleTrigger("trigger1_1","tgroup1");
            simpleTrigger.setStartTime(new Date());

            //60秒后开始执行
            //simpleTrigger.setStartTime(new Date(System.currentTimeMillis() + 60000L));
            simpleTrigger.setRepeatInterval(2000);
            simpleTrigger.setRepeatCount(100);

            //通过StdSchedulerFactory获取调度器实例
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();

            //注册并运行调度
            scheduler.scheduleJob(jobDetail,simpleTrigger);
            //调度启动
            scheduler.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
