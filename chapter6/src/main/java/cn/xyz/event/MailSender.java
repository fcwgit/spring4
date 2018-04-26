package cn.xyz.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MailSender implements ApplicationContextAware {
    private ApplicationContext applicationContext ;
    @Override
    //实现ApplicationContextAware接口方法，以便容器启动时注入容器实例
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void sendMail(String to){
        System.out.println("模拟发送邮件……");
        MailSendEvent mailSendEvent = new MailSendEvent(this.applicationContext,to);
        //向容器中所有事件监听器发送事件
        this.applicationContext.publishEvent(mailSendEvent);
    }
}
