package org.example.tinyioc.aop;

public interface PointcutAdvisor extends Advisor {
    Pointcut getPointcut();
}
