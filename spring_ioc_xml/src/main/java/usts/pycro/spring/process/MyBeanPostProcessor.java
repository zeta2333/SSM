package usts.pycro.spring.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-20 22:37
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // 此方法在bean的生命周期初始化之前执行
        System.out.println("MyBeanPostProcessor后置处理器.postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 此方法在bean的生命周期初始化之前执行
        System.out.println("MyBeanPostProcessor后置处理器.postProcessAfterInitialization");
        return bean;
    }
}
