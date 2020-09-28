package org.example.tinyioc.xml;

import org.example.tinyioc.BeanDefinition;
import org.example.tinyioc.io.ResourceLoader;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class XmlBeanDefinitionReaderTest {
    @Test
    public void test() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinition("tinyioc.xml");
        Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
        Assert.assertTrue(registry.size() > 0);
        System.out.println(registry);
    }
}
