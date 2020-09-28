package org.example.tinyioc.context;

import org.example.tinyioc.HelloService;
import org.junit.Test;

public class ApplicationContextTest {
    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");
        HelloService helloService = (HelloService) applicationContext.getBean("helloService");
        helloService.hello();
    }
}
