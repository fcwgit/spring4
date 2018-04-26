package cn.xyz.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EventTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new  ClassPathXmlApplicationContext("beans.xml");
        MailSender mailSender = (MailSender)applicationContext.getBean("mailSender");
        mailSender.sendMail("zhangsan");
    }
}
