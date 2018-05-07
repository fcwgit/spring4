package cn.xyz.smart.fun;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.Ordered;

@Aspect
public class TestAspect implements Ordered{
    @Before("target(cn.xyz.smart.NaiveWaiter) && args(name,num,..))")
    public void bindJoinPointParams(int num,String name){
        System.out.println("--bindJoinPointParams()--");
        System.out.println("name:" + name);
        System.out.println("num:" + num);
        System.out.println("--bindJoinPointParams()--");
    }

    //环绕增强
    @Around("execution(* greetTo(..)) && target(cn.xyz.smart.NaiveWaiter)")
    public void joinPointAccess(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {//声明连接点入参
        System.out.println("--joinPointAccess--");

        //访问连接点信息
        System.out.println("args[0]:" + proceedingJoinPoint.getArgs()[0]);
        System.out.println("signature:" + proceedingJoinPoint.getTarget().getClass());
        //通过连接点执行目标对象方法
        proceedingJoinPoint.proceed();
        System.out.println("--joinPointAccess--");
    }

    @Before("cn.xyz.smart.advanced.TestNamePointcut.inPkgGreetTo()")
    public void pkgGreetTo(){
        System.out.println("--pkgGreetTo() executed!--");
    }

    @Before("!target(cn.xyz.smart.NaiveWaiter) && cn.xyz.smart.advanced.TestNamePointcut.inPkgGreetTo()")
    public void pkgGreetToNotNaiveWaiter(){
        System.out.println("--pkgGreetToNotNaiveWaiter() executed!--");
    }

    @AfterReturning("@annotation(cn.xyz.annotation.NeedTest)")
    public void needTestFun(){
        System.out.println("needTestFun() executed!");
    }

    @Override
    public int getOrder() {
        return 0;
    }

    //与运算
    @After("within(cn.xyz.smart.*) && execution(* greetTo(..))")
    public void greetToFun(){
        System.out.println("greetToFun()");
    }

    //非运算
    @Before("!target(cn.xyz.smart.NaiveWaiter) && execution(* serveTo(..))")
    public void notServeInNaiveWaiter(){
        System.out.println("notServeInNaiveWaiter()");
    }

    @AfterReturning("target(cn.xyz.smart.Waiter) || target(cn.xyz.smart.Seller)")
    public void waiterOrSeller(){
        System.out.println("waiterOrSeller()");
    }
}
