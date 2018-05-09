package cn.xyz.cache.initcache;

import cn.xyz.cache.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        UserService userService = (UserService)context.getBean("initUserService");
        User user1 = userService.getUser(1);
        System.out.println(user1);
        User user2 = userService.getUser(2);
        System.out.println(user2);
    }
}
