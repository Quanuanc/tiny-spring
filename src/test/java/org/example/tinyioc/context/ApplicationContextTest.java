package org.example.tinyioc.context;

import org.example.tinyioc.HelloWorldService;
import org.junit.Test;

public class ApplicationContextTest {
    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");
        HelloWorldService helloService = (HelloWorldService) applicationContext.getBean("helloWorldService");
        helloService.helloWorld();
    }
}
