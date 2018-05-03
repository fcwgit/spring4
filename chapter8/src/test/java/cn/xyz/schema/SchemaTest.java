package cn.xyz.schema;

import cn.xyz.smart.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class SchemaTest {
    @Test
    public void schemaTest(){
        String configPath = "schema.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);

        Waiter naiveWaiter = (Waiter)context.getBean("naiveWaiter");
        Waiter naughtyWaiter = (Waiter)context.getBean("naughtyWaiter");

        naiveWaiter.greetTo("Tom");
        naughtyWaiter.greetTo("Jom");
    }
}
