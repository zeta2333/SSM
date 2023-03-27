package usts.pycro.spring.service;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-27 11:36
 */
public interface CheckoutService {
    /**
     * 结账
     *
     * @param userId
     * @param bookIds
     */
    void checkout(Integer userId, Integer[] bookIds);
}
