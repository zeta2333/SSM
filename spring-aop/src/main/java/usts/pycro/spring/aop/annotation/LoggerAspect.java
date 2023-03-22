package usts.pycro.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-21 22:25
 * 1.在切面中，需要通过指定的注解将方法标识为通知方法
 * @Before：前置通知，在目标对象方法执行之前调用的通知
 * @After：后置通知，在目标对象方法的finally语句中执行的通知
 * @AfterReturning：返回通知，在方目标对象法成功执行后执行的通知 2.切入点表达式：设置在标识通知的注解的value属性中
 * execution(public int usts.pycro.spring.aop.annotation.CalculatorImpl.add(int,int))
 * execution(* usts.pycro.spring.aop.annotation.CalculatorImpl.*(..))
 * 第一个*表示任意的访问修饰符和返回值类型
 * 第二个*表示指定类中的任意方法
 * ..表示任意的参数列表
 * 类的地方也可以用*，表示包下所有的类
 * <p>
 * 3.重用切入点表达式
 * //@Pointcut声明一个公共的切入点表达式
 * @Pointcut("execution(* usts.pycro.spring.aop.annotation.CalculatorImpl.*(..))")
 * public void pointCut(){}
 * <p>
 * 4.获取连接点的信息
 * 在通知方法的参数位置，设置JoinPoint类型的参数，就可以获取连接点所对应的方法的信息
 * //获取连接点所对应方法的签名信息
 * Signature signature = joinPoint.getSignature();
 * //获取连接点所对应方法的参数列表
 * Object[] args = joinPoint.getArgs();
 *
 * 5.Aspect的优先级
 * 可以通过@Order注解设置切面的优先级，默认值Integer.MAX_VALUE（2147483647）
 * @Order 数值越大，优先级越低
 */
@Component
@Aspect // 将当前组件标识为一个切面
public class LoggerAspect {

    //切入点表达式方法
    @Pointcut("execution(* usts.pycro.spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointCut() {
    }


    //@Before("execution(public int usts.pycro.spring.aop.annotation.CalculatorImpl.add(int,int))")
    //@Before("execution(* usts.pycro.spring.aop.annotation.CalculatorImpl.*(..))")
    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint) {
        //获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        //获取连接点所对应方法的参数列表
        Object[] args = joinPoint.getArgs();
        System.out.println("[LoggerAspect] 方法：" + signature.getName() + ",参数" + Arrays.toString(args));
    }

    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("[LoggerAspect] 方法：" + signature.getName() + "，执行完毕");
    }

    /*
    在返回通知中若想获取目标方法的返回值
    就要在@AfterReturning注解中配置returning
    将某个指定的参数作为目标方法的返回值的接收参数
     */
    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result) {
        Signature signature = joinPoint.getSignature();
        System.out.println("[LoggerAspect] 方法：" + signature.getName() + ",结果：" + result);
    }

    /*
    在异常通知中若想获取目标方法抛出的异常
    就要在@AfterThrowing注解中配置throwing
    将某个指定的参数作为目标方法出现的异常的接收参数
     */
    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Exception e) {
        Signature signature = joinPoint.getSignature();
        System.out.println("[LoggerAspect] 方法：" + signature.getName() + ",异常：" + e);
    }

    @Around("pointCut()")
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
