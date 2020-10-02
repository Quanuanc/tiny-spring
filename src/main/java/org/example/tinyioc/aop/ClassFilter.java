package org.example.tinyioc.aop;

public interface ClassFilter {
    boolean matches(Class targetClass);
}
