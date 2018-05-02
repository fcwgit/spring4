package cn.xyz.annotation;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ToolTest {
    @Test
    public void tool(){
        //得到ForumService对应的Class对象
        Class clazz = ForumService.class;
        //得到ForumService对应的Method数组
        Method[] methods = clazz.getMethods();
        System.out.println(methods.length);

        for (Method method:methods){
            NeedTest needTest = method.getAnnotation(NeedTest.class);
            if (needTest != null){
                if (needTest.value()){
                    System.out.println(method.getName() + "()需要测试");
                }else {
                    System.out.println(method.getName() + "()不需要测试");
                }
            }
        }
    }
}
