package usts.pycro.spring.test.proxy;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-21 20:47
 */
public class CalculatorStaticProxy implements Calculator {

    private Calculator target;

    public CalculatorStaticProxy(CalculatorImpl calculator) {
        this.target = calculator;
    }

    @Override
    public int add(int i, int j) {
        System.out.println("[日志] 方法：add,参数" + i + "," + j);
        int res = target.add(i, j);
        System.out.println("[日志] 方法：add,结果" + res);
        return res;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("[日志] 方法：sub,参数" + i + "," + j);
        int res = target.sub(i, j);
        System.out.println("[日志] 方法：sub,结果" + res);
        return res;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("[日志] 方法：mul,参数" + i + "," + j);
        int res = target.mul(i, j);
        System.out.println("[日志] 方法：mul,结果" + res);
        return res;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("[日志] 方法：div,参数" + i + "," + j);
        int res = target.div(i, j);
        System.out.println("[日志] 方法：div,结果" + res);
        return res;
    }
}
