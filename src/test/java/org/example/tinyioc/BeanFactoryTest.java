package org.example.tinyioc;

import org.example.tinyioc.service.FirstService;
import org.example.tinyioc.service.SecondService;
import org.junit.Test;

public class BeanFactoryTest {
    @Test
    public void test() {
        //1. 创建 beanFactory
        BeanFactory beanFactory = new BeanFactory();

        //2. 注入 bean
        BeanDefinition firstDefinition = new BeanDefinition(new FirstService());
        BeanDefinition secondDefinition = new BeanDefinition(new SecondService());
        beanFactory.registerBeanDefinition("firstDefinition", firstDefinition);
        beanFactory.registerBeanDefinition("secondDefinition", secondDefinition);

        //3. 取出 bean
        FirstService firstService = (FirstService) beanFactory.getBean("firstDefinition");
        SecondService secondService = (SecondService) beanFactory.getBean("secondDefinition");
        firstService.doSomething();
        secondService.doSomething();
    }
}
