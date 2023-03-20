package usts.pycro.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-20 20:46
 */
public class DataSourceTest {
    @Test
    public void testDataSource() throws SQLException {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-datasource.xml");
        //DruidDataSource dataSource = ioc.getBean(DruidDataSource.class);
        DataSource bean = ioc.getBean(DataSource.class);
        //System.out.println(dataSource.getConnection());
        System.out.println(bean.getConnection());
    }
}
