package cn.xyz.event;

import org.springframework.context.ApplicationListener;

public class MailSendListener implements ApplicationListener<MailSendEvent> {
    @Override
    public void onApplicationEvent(MailSendEvent event) {
        MailSendEvent mailSendListener = (MailSendEvent)event;
        System.out.println("MailSendListener:向" + mailSendListener.getTo() + "发送完一封邮件");
    }
}
