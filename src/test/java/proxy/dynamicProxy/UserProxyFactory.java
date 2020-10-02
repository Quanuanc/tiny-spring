package proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理对象
 */
public class UserProxyFactory {
    private Object target; //维护一个目标对象

    public UserProxyFactory(Object target) {
        this.target = target;
    }

    // 为目标对象生成的代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        long time = System.nanoTime();
                        System.out.println("开启事务");
                        //执行目标对象方法
                        Object returnValue = method.invoke(target, args);
                        System.out.println("提交事务, 耗时 " + (System.nanoTime() - time) + " nanoseconds");
                        return returnValue;
                    }
                });
    }
}
