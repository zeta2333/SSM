package usts.pycro.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import usts.pycro.spring.aop.xml.Calculator;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-22 15:05
 */
public class AOPByXMLTest {
    @Test
    public void testAOPByXML() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-xml.xml");
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.div(10, 2);
    }
}
