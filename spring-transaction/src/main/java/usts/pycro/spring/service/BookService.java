package usts.pycro.spring.service;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-27 10:21
 */
public interface BookService {
    /**
     * 买书
     *
     * @param userId
     * @param bookId
     */
    void buyBook(Integer userId, Integer bookId);
}
