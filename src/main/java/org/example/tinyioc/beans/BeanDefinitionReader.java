package org.example.tinyioc.beans;

public interface BeanDefinitionReader {
    void loadBeanDefinition(String location) throws Exception;
}
