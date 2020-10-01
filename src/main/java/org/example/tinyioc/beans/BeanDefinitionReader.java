package org.example.tinyioc.beans;

/**
 * 从配置中读取BeanDefinition
 */
public interface BeanDefinitionReader {
    void loadBeanDefinition(String location) throws Exception;
}
