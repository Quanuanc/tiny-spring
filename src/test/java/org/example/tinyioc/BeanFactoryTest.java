package org.example.tinyioc;

import org.example.tinyioc.factory.AutoCapableBeanFactory;
import org.example.tinyioc.factory.BeanFactory;
import org.junit.Test;

public class BeanFactoryTest {
    @Test
    public void test() throws Exception {
        // 1. 初始化beanFactory
        BeanFactory beanFactory = new AutoCapableBeanFactory();

        // 2. bean定义
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("org.example.tinyioc.HelloService");

        // 3.设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("text", "Hello From Service"));
        beanDefinition.setPropertyValues(propertyValues);

        // 4.生成bean
        beanFactory.registerBeanDefinition("helloService", beanDefinition);

        // 5. 获取bean
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        helloService.hello();
    }
}
