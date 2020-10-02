package org.example.tinyioc.aop;

public class TargetSource {
    private Class targetClass;
    private Object target;

    public TargetSource(Object target, Class<?> targetClass) {
        this.targetClass = targetClass;
        this.target = target;
    }

    public Class getTargetClass() {
        return targetClass;
    }

    public Object getTarget() {
        return target;
    }
}
