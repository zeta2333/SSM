package usts.pycro.spring.test.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import usts.pycro.spring.test.controller.UserController;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-21 12:36
 */
public class AnnotationTest {
    /**
     * @Component：将类标识为普通组件
     * @Controller：将类标识为控制层组件
     * @Service：将类标识为业务层组件
     * @Repository：将类标识为持久层组件 说明：这四个注解的功能相同，可以混着用
     * 但实际开发中为了让程序员明白，对于特定的类建议用具体的注解标记
     *
     * 通过注解+扫描配置的bean的id，默认值为类的小驼峰，即类名首字母小写后的结果
     * 可以通过设置组件的注解的value值来自定义bean的id
     *
     * @Autowired：实现自动装配功能的注解
     * 1.标识的位置
     * a>标识在成员变量上，此时不需要设置set方法
     * b>标识在set方法上
     * c>标识在为当前成员变量赋值的有参构造器上
     * 2.原理
     * a>默认通过byType的方式，在IOC容器中通过类型匹配某个bean为属性赋值
     * b>若有多个类型匹配的bean，此时会自动转换为byName的方式实现自动装配的效果
     * c>若byType和byName的方式都无法自动装配，即IOC容器中存在多个类型匹配的bean
     * 但这些bean的id和要赋值的属性的属性名均不一致，此时抛出异常：NoUniqueBeanDefinitionException
     * d>此时可以在要赋值的属性上，添加@Qualifier注解
     * 通过该注解的value属性值，指定某个bean的id，将这个bean为属性赋值
     *
     * 注意：若IOC容器中没有任何一个类型匹配的bean，此时抛出异常：NoSuchBeanDefinitionException
     * 在@Autowired注解中有个属性required，默认值为true，要求必须完成自动装配
     * 可以将required设置为false，此时能装配则装配，无法装配则使用属性的默认值
     */
    @Test
    public void testAnnotation() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController = ioc.getBean(UserController.class);
        userController.saveUser();
    }
}
