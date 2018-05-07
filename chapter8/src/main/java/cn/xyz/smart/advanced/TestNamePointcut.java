package cn.xyz.smart.advanced;

import org.aspectj.lang.annotation.Pointcut;

public class TestNamePointcut {
    @Pointcut("within(cn.xyz.*)")
    private void inPackage(){};

    @Pointcut("execution(* greetTo(..))")
    protected void greetTo(){};

    @Pointcut("inPackage() && greetTo()")
    public void inPkgGreetTo(){};
}
