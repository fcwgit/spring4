package cn.xyz.advice;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeforeSpringTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Waiter waiter = (Waiter)applicationContext.getBean("waiter");
        waiter.greetTo("Tom");
    }
}
