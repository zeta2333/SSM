package usts.pycro.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import usts.pycro.spring.controller.UserController;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-20 23:30
 */
public class AutowireByXmlTest {
    @Test
    public void testAutowireByXml(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowire-xml.xml");
        UserController userController = ioc.getBean(UserController.class);
        userController.saveUser();
    }
}
