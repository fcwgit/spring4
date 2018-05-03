package cn.xyz.aspectj;

import org.junit.Test;
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

    @Test
    public void aspectJProxyTest(){
        Waiter waiter = new NaiveWaiter();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        //设置目标对象
        factory.setTarget(waiter);
        //添加切面类
        factory.addAspect(PreGreetingAspect.class);
        //生成织入切面的代理类
        Waiter proxyWaiter = factory.getProxy();
        proxyWaiter.greetTo("tom");
        proxyWaiter.serveTo("Jom");
    }
}
