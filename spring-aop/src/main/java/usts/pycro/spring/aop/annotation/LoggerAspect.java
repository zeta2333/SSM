package usts.pycro.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-21 22:25
 * 1.在切面中，需要通过指定的注解将方法标识为通知方法
 * @Before：前置通知
 *
 *
 * 2.切入点表达式：设置在标识通知的注解的value属性中
 * execution(public int usts.pycro.spring.aop.annotation.CalculatorImpl.add(int,int))
 * execution(* usts.pycro.spring.aop.annotation.CalculatorImpl.*(..))
 * 第一个*表示任意的访问修饰符和返回值类型
 * 第二个*表示指定类中的任意方法
 * ..表示任意的参数列表
 * 类的地方也可以用*，表示包下所有的类
 *
 * 3.重用切入点表达式
 * //@Pointcut声明一个公共的切入点表达式
 * @Pointcut("execution(* usts.pycro.spring.aop.annotation.CalculatorImpl.*(..))")
 * public void pointCut(){}
 *
 * 4.获取连接点的信息
 * 在通知方法的参数位置，设置JoinPoint类型的参数，就可以获取连接点所对应的方法的信息
 * //获取连接点所对应方法的签名信息
 * Signature signature = joinPoint.getSignature();
 * //获取连接点所对应方法的参数列表
 * Object[] args = joinPoint.getArgs();
 */
@Component
@Aspect // 将当前组件标识为一个切面
public class LoggerAspect {

    //切入点表达式方法
    @Pointcut("execution(* usts.pycro.spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointCut(){}


    //@Before("execution(public int usts.pycro.spring.aop.annotation.CalculatorImpl.add(int,int))")
    //@Before("execution(* usts.pycro.spring.aop.annotation.CalculatorImpl.*(..))")
    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint) {
        //获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        //获取连接点所对应方法的参数列表
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect：方法：" + signature.getName() + ",参数" + Arrays.toString(args));
    }

    @After("pointCut()")
    public void afterAdviceMethod(){

    }
}
