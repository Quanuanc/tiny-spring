package proxy;

import org.junit.Test;
import proxy.dynamicProxy.UserProxyFactory;
import proxy.staticProxy.UserDaoProxy;

/**
 * 测试两种代理模式
 * https://segmentfault.com/a/1190000011291179
 */
public class TestProxy {
    /**
     * 静态代理测试
     */
    @Test
    public void testStaticProxy() {
        IUserDao target = new UserDao();
        UserDaoProxy proxy = new UserDaoProxy(target);
        proxy.save();
    }

    /**
     * 动态代理测试
     */
    @Test
    public void testDynamicProxy() {
        IUserDao target = new UserDao();
        System.out.println(target.getClass());
        IUserDao proxy = (IUserDao) new UserProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());
        proxy.save();
    }
}
