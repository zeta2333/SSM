package usts.pycro.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-21 21:12
 * 动态代理工厂：生产动态代理类的类
 *
 * 动态代理有两种：
 * 1.jdk动态代理，要求必须有接口，最终生成的代理类和目标类实现相同的接口
 * 代理类在com.sum.proxy包下，类名为$proxy2
 * 2.cglib动态代理，最终生成的代理类会继承目标类，并且和目标类在相同的包下
 */
public class ProxyFactory {
    // 代理类的目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 生产代理类
     *
     * @return
     */
    public Object getProxy() {
        /*
        ClassLoader loader:指定加载动态生成的代理类的类加载器，此处使用应用类加载器
        Class<?>[] interfaces:获取目标对象所实现的所有接口的Class对象的数组
        InvocationHandler h:
         */
        ClassLoader loader = this.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object res = null;
                try {
                    System.out.println("[日志] 方法：" + method.getName() + "，参数：" + Arrays.toString(args));
                    // proxy表示代理对象，method表示要执行的方法，args表示要执行的方法的参数列表
                    res = method.invoke(target, args);
                    System.out.println("[日志] 方法：" + method.getName() + "，结果：" + res);

                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("[日志] 方法：" + method.getName() + "，异常：" + e);
                } finally {
                    System.out.println("[日志] 方法：" + method.getName() + "，方法执行完毕！" );
                }
                return res;
            }
        };
        return Proxy.newProxyInstance(loader, interfaces, h);
    }
}
