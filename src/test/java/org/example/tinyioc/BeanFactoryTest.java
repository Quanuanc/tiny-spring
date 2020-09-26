package org.example.tinyioc;

import org.example.tinyioc.factory.AutoCapableBeanFactory;
import org.example.tinyioc.factory.BeanFactory;
import org.junit.Test;

public class BeanFactoryTest {
    @Test
    public void test() {
        // 1. 初始化beanFactory
        BeanFactory beanFactory = new AutoCapableBeanFactory();

        // 2. 注入bean
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanCLassName("org.example.tinyioc.HelloService");
        beanFactory.registerBeanDefinition("helloService", beanDefinition);

        // 3. 获取bean
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        helloService.hello();
    }
}
