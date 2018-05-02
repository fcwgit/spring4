package cn.xyz.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect //通过该注解将PreGreetingAspect标识位一个切面
public class PreGreetingAspect {
    @Before("execution(* greetTo(..))")//定义切点和增强类型
    public void beforeGreeting(){//增强的横切逻辑
        System.out.println("How are you.");
    }

}
