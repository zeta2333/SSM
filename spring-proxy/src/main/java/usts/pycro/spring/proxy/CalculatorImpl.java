package usts.pycro.spring.proxy;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-21 20:18
 */
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        int res = i + j;
        System.out.println("方法内部：res = " + res);
        return res;
    }

    @Override
    public int sub(int i, int j) {
        int res = i - j;
        System.out.println("方法内部：res = " + res);
        return res;
    }

    @Override
    public int mul(int i, int j) {
        int res = i * j;
        System.out.println("方法内部：res = " + res);
        return res;
    }

    @Override
    public int div(int i, int j) {
        int res = i / j;
        System.out.println("方法内部：res = " + res);
        return res;
    }
}
