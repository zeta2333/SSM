package usts.pycro.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import usts.pycro.spring.pojo.Student;

/**
 * @Author Pycro
 * @Create 2023-03-17  16:36
 * @Description
 * @Version 1.0
 */
public class IoCByXMLTest {
    /*
    IOC容器中获取bean的方式：
    1.根据bean的id获取
    2.根据bean的类型获取
    注意：根据类型获取bean时，要求IoC容器中有且只有一个类型匹配的bean
    若没有任何一个类型匹配的bean，此时抛出异常：NoSuchBeanDefinitionException
    若有多个类型匹配的bean，此时抛出异常：NoUniqueBeanDefinitionException
    3.根据bean的id和类型获取
    结论：
    根据类型来获取bean时，在满足bean唯一性的前提下
    其实只是看：『对象 instanceof 指定的类型』的返回结果
    只要返回的是true就可以认定为和类型匹配，能够获取到。
    即：通过类本身、类所继承的父类或者类所实现的接口都可以获取bean
     */
    @Test
    public void testStudent() {
        // 创建IoC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        // 获取Bean
        //Student studentOne = (Student) ioc.getBean("studentOne");
        Student student = ioc.getBean(Student.class);
        //student = ioc.getBean("studentOne", Student.class);
        //Animal bean = ioc.getBean(Animal.class);
        //Person person = ioc.getBean(Person.class);
        System.out.println(student);
    }

    @Test
    public void testDI() {
        // 获取IoC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //获取bean
        Student student = ioc.getBean("stu6", Student.class);
        System.out.println(student);
        //Clazz clazz = ioc.getBean("clazz1", Clazz.class);
        //System.out.println(clazz);
    }
}
