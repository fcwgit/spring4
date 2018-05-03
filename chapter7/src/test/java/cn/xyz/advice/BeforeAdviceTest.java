package cn.xyz.advice;

import org.junit.Test;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class BeforeAdviceTest {
    @Test
    public void before(){
        Waiter target = new NaiveWaiter();
        BeforeAdvice beforeAdvice = new GreetingBeforeAdvice();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);

        proxyFactory.addAdvice(beforeAdvice);

        Waiter proxy = (Waiter)proxyFactory.getProxy();

        proxy.greetTo("Tom");

        proxy.greetTo("John");
    }
}
