package usts.pycro.spring.test.test;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import usts.pycro.spring.test.pojo.User;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-20 22:14
 */
public class LifeCycleTest {
    /**
     * 1.实例化
     * 2.依赖注入
     * 3.初始化之前，后置处理器执行postProcessBeforeInitialization
     * 4.初始化，通过bean对象的init-method属性配置
     * 5.初始化之后，后置处理器执行postProcessAfterInitialization
     * 6.IOC容器关闭时销毁，通过bean对象的destroy-method属性配置
     *
     * bean的后置处理器会在生命周期的初始化前后添加额外的操作
     * 需要实现BeanPostProcessor接口，且配置到IOC容器中
     * bean后置处理器不是单独针对某一个bean生效，而是针对IOC容器中所有bean都会执行
     * 注意：
     * 若bean的作用域为单例，则生命周期的前三个步骤会在获取IOC容器时执行
     * 若bean的作用域为多例，则生命周期的前三个步骤会在获取bean时执行
     */
    @Test
    public void testLifeCycle() {
        //ConfigurableApplicationContext是ApplicationContext的子接口，其中扩展了刷新和关闭容器的方法
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User user = ioc.getBean(User.class);
        System.out.println(user);
        ioc.close();
    }
}
