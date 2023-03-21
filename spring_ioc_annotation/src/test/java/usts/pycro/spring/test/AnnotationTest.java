package usts.pycro.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import usts.pycro.spring.controller.UserController;
import usts.pycro.spring.dao.UserDao;
import usts.pycro.spring.service.UserService;

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
     */
    @Test
    public void testAnnotation() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController = ioc.getBean(UserController.class);
        System.out.println(userController);
        UserService userService = ioc.getBean(UserService.class);
        System.out.println(userService);
        UserDao userDao = ioc.getBean(UserDao.class);
        System.out.println(userDao);
    }
}
