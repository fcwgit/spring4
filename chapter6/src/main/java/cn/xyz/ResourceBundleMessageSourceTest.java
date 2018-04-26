package cn.xyz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.GregorianCalendar;
import java.util.Locale;

public class ResourceBundleMessageSourceTest {
    public static void main(String[] args) {
        String[] configs = {"beans.xml"};
        ApplicationContext context = new ClassPathXmlApplicationContext(configs);
        MessageSource messageSource = (MessageSource)context.getBean("myResource2");

        Object[] params = {"John",new GregorianCalendar().getTime()};
        System.out.println(messageSource.getMessage("greeting.common",params, Locale.US));
        System.out.println(messageSource.getMessage("greeting.morning",params, Locale.CHINA));
        System.out.println(messageSource.getMessage("greeting.afternoon",params, Locale.CHINA));


        //<bean id="messageSource" bean的id必须为messageSource
        System.out.println(context.getMessage("greeting.common",params, Locale.US));
        System.out.println(context.getMessage("greeting.morning",params, Locale.CHINA));
        System.out.println(context.getMessage("greeting.afternoon",params, Locale.CHINA));
    }
}
