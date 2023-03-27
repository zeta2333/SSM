package usts.pycro.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import usts.pycro.spring.controller.BookController;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-27 10:37
 * 声明式事务的配置步骤：
 * 1.在Spring的配置文件中配置事务管理器
 * 2.开启事务的注解驱动
 * 在需要被事务管理的方法上添加@Transactional注解，该方法就会被事务管理
 * @Transactional注解标识的位置： 1.方法上
 * 2.类上，则类中所有的方法都会被事务管理
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:tx-xml.xml")
public class TxByXMLTest {
    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook() {
        bookController.buyBook(1, 1);
        //bookController.checkout(1, new Integer[]{1,2});
    }
}
