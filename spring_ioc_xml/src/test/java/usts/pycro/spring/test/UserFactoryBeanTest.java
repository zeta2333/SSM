package usts.pycro.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import usts.pycro.spring.pojo.User;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-20 23:01
 * FactoryBean是一个接口，需要创建一个类实现该接口
 * 其中有三个方法：
 * getObject()：提供一个对象交给ioc容器管理
 * getObjectType()：设置所提供对象的类型
 * isSingleton()：所提供的对象是否单例
 * 当把FactoryBean的实现类配置为bean时，会将当前类中getObject()所返回的对象交给IOC容器管理
 */
public class UserFactoryBeanTest {
    @Test
    public void testUserFactoryBean() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-factory.xml");
        User user = ioc.getBean(User.class);
        System.out.println(user);
    }
}
