package usts.pycro.spring.test.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import usts.pycro.spring.test.pojo.HelloWorld;

/**
 * @Author Pycro
 * @Create 2023-03-17  15:56
 * @Description
 * @Version 1.0
 */
public class HelloWorldTest {

    @Test
    public void testHelloWorld() {
        // 获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationCotext.xml");
        // 从ioc中获取bean
        HelloWorld helloWorld = (HelloWorld) ioc.getBean("helloWorld");
        helloWorld.sayHello();
    }
}
