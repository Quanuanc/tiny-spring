package org.example.tinyioc;

import org.example.tinyioc.beans.BeanDefinition;
import org.example.tinyioc.beans.factory.AutowireCapableBeanFactory;
import org.example.tinyioc.beans.io.ResourceLoader;
import org.example.tinyioc.beans.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

public class BeanFactoryTest {
    @Test
    public void test() throws Exception {
        // 1. 读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinition("tinyioc.xml");

        // 2. 初始化beanFactory并注册bean
        AutowireCapableBeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> entry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(entry.getKey(), entry.getValue());
        }

        // 3. 获取bean
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        helloService.hello();
    }
}
