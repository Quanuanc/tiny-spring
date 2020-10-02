package org.example.tinyioc.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class TestInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("before invocation");
        Object returnValue = invocation.proceed();
        System.out.println("after invocation");
        return returnValue;
    }
}
