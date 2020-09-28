package org.example.tinyioc.beans.factory;

import org.example.tinyioc.beans.BeanDefinition;
import org.example.tinyioc.beans.PropertyValue;

import java.lang.reflect.Field;

public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        applyPropertyValue(bean, beanDefinition);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    protected void applyPropertyValue(Object bean, BeanDefinition beanDefinition) throws Exception {
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
            Field declareField = bean.getClass().getDeclaredField(propertyValue.getName());
            declareField.setAccessible(true);
            declareField.set(bean, propertyValue.getValue());
        }
    }

}
