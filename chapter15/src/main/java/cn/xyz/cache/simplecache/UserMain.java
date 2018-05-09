package cn.xyz.cache.simplecache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService)context.getBean("userServiceBean");

        System.out.println("first query ...");
        userService.getUserById("somebody");
        System.out.println("second query ...");
        userService.getUserById("somebody");
    }
}
