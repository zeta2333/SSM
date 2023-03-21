package usts.pycro.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import usts.pycro.spring.aop.annotation.Calculator;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-21 22:48
 */
public class AOPTest {
    @Test
    public void testAOPByAnnotation() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-annotation.xml");
        Calculator calculator = ioc.getBean(Calculator.class);
        System.out.println(calculator.getClass());//class jdk.proxy2.$Proxy14，说明这里获取的bean是代理类
        calculator.sub(1, 2);
    }
}
