package usts.pycro.spring.aop.xml;

import org.springframework.stereotype.Component;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-22 14:32
 */
@Component

public class ValidateAspect {
    public void beforeAdviceMethod() {
        System.out.println("Validate -> 前置通知");
    }
}
