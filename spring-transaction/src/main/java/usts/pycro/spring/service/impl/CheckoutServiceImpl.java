package usts.pycro.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usts.pycro.spring.service.BookService;
import usts.pycro.spring.service.CheckoutService;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-27 11:36
 */
@Service
public class CheckoutServiceImpl implements CheckoutService {
    @Autowired
    private BookService bookService;

    @Override
    //@Transactional
    public void checkout(Integer userId, Integer[] bookIds) {
        for (Integer bookId : bookIds) {
            bookService.buyBook(userId, bookId);
        }
    }
}
