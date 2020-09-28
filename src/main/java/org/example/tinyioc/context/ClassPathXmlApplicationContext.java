package org.example.tinyioc.context;

import org.example.tinyioc.beans.BeanDefinition;
import org.example.tinyioc.beans.factory.AbstractBeanFactory;
import org.example.tinyioc.beans.factory.AutowireCapableBeanFactory;
import org.example.tinyioc.beans.io.ResourceLoader;
import org.example.tinyioc.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

public class ClassPathXmlApplicationContext implements ApplicationContext {
    private AbstractBeanFactory beanFactory;
    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) {
        this(configLocation,new AutowireCapableBeanFactory());
    }

    public ClassPathXmlApplicationContext(String configLocation,AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
        this.configLocation = configLocation;
        try{
            refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refresh() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinition(configLocation);
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
    }

    @Override
    public Object getBean(String name) {
        return beanFactory.getBean(name);
    }
}
