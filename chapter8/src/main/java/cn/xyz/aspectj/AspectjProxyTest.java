package cn.xyz.aspectj;

import javafx.application.Application;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectjProxyTest {
    public static void main(String[] args) {
        //AspectJProxyFactory aspectJProxyFactory = new AspectJProxyFactory();
        //
        //NaiveWaiter target = new NaiveWaiter();
        //
        //aspectJProxyFactory.setTarget(target);
        //
        //aspectJProxyFactory.addAspect(PreGreetingAspect.class);
        //
        //Waiter proxy = aspectJProxyFactory.getProxy();
        //
        //proxy.greetTo("Tom");

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Waiter waiter = (Waiter)context.getBean("waiter");

        waiter.greetTo("Tom");
    }
}
