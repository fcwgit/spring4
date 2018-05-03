package cn.xyz.smart.fun;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TestAspect {
    @AfterReturning("@annotation(cn.xyz.annotation.NeedTest)")
    public void needTestFun(){
        System.out.println("needTestFun() executed!");
    }
}
