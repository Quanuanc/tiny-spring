package org.example.tinyioc;

public interface BeanDefinitionReader {
    void loadBeanDefinition(String location) throws Exception;
}
