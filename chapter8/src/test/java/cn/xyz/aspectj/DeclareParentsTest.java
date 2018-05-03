package cn.xyz.aspectj;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeclareParentsTest {
    @Test
    public void declareParentTest(){
        String configPath = "DeclareParents.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter)applicationContext.getBean("waiter");
        waiter.greetTo("Tom");

        Seller seller = (Seller)waiter;
        seller.sell("Tea");
    }
}
