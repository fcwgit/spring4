package cn.xyz.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdvisorTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Waiter waiter = (Waiter)applicationContext.getBean("waiter");
        Seller seller = (Seller)applicationContext.getBean("seller");

        waiter.greetTo("Tom");
        seller.greetTo("John");


        Waiter waiter1 = (Waiter)applicationContext.getBean("waiter1");

        waiter1.greetTo("zhangsan");
        waiter1.serveTo("zhangsan");
    }
}
