package usts.pycro.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import usts.pycro.spring.service.BookService;
import usts.pycro.spring.service.CheckoutService;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-27 10:21
 */
@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CheckoutService checkoutService;

    public void buyBook(Integer userId, Integer bookId) {
        bookService.buyBook(userId, bookId);
    }

    public void checkout(Integer userId, Integer[] bookIds) {
        checkoutService.checkout(userId, bookIds);
    }
}
