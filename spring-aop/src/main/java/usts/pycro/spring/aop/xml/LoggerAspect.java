package usts.pycro.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-21 22:25
 */
@Component

public class LoggerAspect {

    public void beforeAdviceMethod(JoinPoint joinPoint) {
        //获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        //获取连接点所对应方法的参数列表
        Object[] args = joinPoint.getArgs();
        System.out.println("[LoggerAspect] 方法：" + signature.getName() + ",参数" + Arrays.toString(args));
    }


    public void afterAdviceMethod(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("[LoggerAspect] 方法：" + signature.getName() + "，执行完毕");
    }


    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result) {
        Signature signature = joinPoint.getSignature();
        System.out.println("[LoggerAspect] 方法：" + signature.getName() + ",结果：" + result);
    }


    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Exception e) {
        Signature signature = joinPoint.getSignature();
        System.out.println("[LoggerAspect] 方法：" + signature.getName() + ",异常：" + e);
    }


    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint) {
        Object result;
        try {
            System.out.println("环绕通知->前置通知");
            //执行目标对象的指定方法
            result = joinPoint.proceed();
            System.out.println("环绕通知->返回通知");
        } catch (Throwable e) {
            System.out.println("环绕通知->异常通知");
            throw new RuntimeException(e);
        } finally {
            System.out.println("环绕通知->后置通知");
        }
        return result;
    }
}
