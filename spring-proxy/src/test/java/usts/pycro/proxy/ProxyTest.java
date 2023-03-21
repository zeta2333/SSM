package usts.pycro.proxy;

import org.junit.Test;
import usts.pycro.spring.test.proxy.Calculator;
import usts.pycro.spring.test.proxy.CalculatorImpl;
import usts.pycro.spring.test.proxy.ProxyFactory;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-21 20:54
 */
public class ProxyTest {
    @Test
    public void testProxy() {
        //CalculatorStaticProxy proxy = new CalculatorStaticProxy(new CalculatorImpl());
        //proxy.add(1,2);
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.div(1,0);
    }
}
