package com.smart;

import com.smart.domain.User;
import com.smart.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("smart-context.xml");
        UserService userService = context.getBean("userService",UserService.class);
        User user = userService.findUserByUserName("admin");
        System.out.println(user.getUserName());
    }
}
