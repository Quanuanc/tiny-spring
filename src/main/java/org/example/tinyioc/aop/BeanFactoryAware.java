package org.example.tinyioc.aop;

import org.example.tinyioc.beans.factory.BeanFactory;

public interface BeanFactoryAware {
    void setBeanFactory(BeanFactory beanFactory) throws Exception;
}
