package cn.xyz.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class GreetingInterceptor implements MethodInterceptor {
    @Override
    //截获目标类方法的执行，并在前后添加横切逻辑
    public Object invoke(MethodInvocation invocation) throws Throwable {
        //目标方法入参
        Object[] args = invocation.getArguments();

        String clientName = (String)args[0];
        //在目标方法执行前调用
        System.out.println("How are you! Mr." + clientName + ".");
        //通过反射机制调用目标方法
        Object object = invocation.proceed();
        //在目标方法执行后调用
        System.out.println("Please enjoy yourself");
        return object;
    }
}
