package usts.pycro.spring.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-22 14:32
 */
@Component
@Aspect
@Order(1)
public class ValidateAspect {
    @Before("usts.pycro.spring.aop.annotation.LoggerAspect.pointCut()")
    public void beforeAdviceMethod() {
        System.out.println("Validate -> 前置通知");
    }
}
