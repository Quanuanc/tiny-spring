package proxy;

/**
 * 目标对象, 被代理的对象
 */
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("保存数据");
    }
}
