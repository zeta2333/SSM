package usts.pycro.spring.test.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import usts.pycro.spring.test.controller.UserController;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-20 23:30
 * 自动装配：autowire
 * 根据指定的策略，在IOC容器中配置某个bean，自动为bean中类类型的属性或者接口类型的属性赋值
 * 通过在bean标签中设置autowire属性，来设置自动装配的策略
 * 自动装配的策略：
 * 1.default、no：表示不装配
 * 2.byType：表示根据要赋值的属性的类型在IOC容器中匹配某个bean，为属性赋值
 * 注意：
 * a>若通过类型没有找到任何一个类型匹配的bean，此时不装配，属性使用默认值
 * b>若通过类型找到了多个类型匹配的bean，此时会抛出异常：NoUniqueBeanDefinitionException
 * 总结：当使用byType实现自动装配时，IOC容器中有且只有一个类型匹配的bean能够为属性赋值
 * 3.byName：表示根据要赋值的属性名在IOC中匹配某个bean，为属性赋值
 * 总结：当类型匹配到多个bean时，此时可以用byName实现自动装配
 */
public class AutowireByXmlTest {
    @Test
    public void testAutowireByXml(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowire-xml.xml");
        UserController userController = ioc.getBean(UserController.class);
        userController.saveUser();
    }
}
