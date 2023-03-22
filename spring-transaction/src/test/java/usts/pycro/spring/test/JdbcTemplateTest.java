package usts.pycro.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-22 15:40
 */
//指定当前测试类在spring的测试环境中执行，此时就可以通过注入的方式直接获取IOC容器中的bean
@RunWith(SpringJUnit4ClassRunner.class)
//设置Spring测试环境的配置文件
@ContextConfiguration("classpath:spring-jdbc.xml")
public class JdbcTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testJdbcTemplate() {
        String sql = "insert into t_user values(null,?,?,?,?,?)";
        int result = jdbcTemplate.update(sql, "root","123",22,"女","213@qq.com");
        System.out.println(result);
    }
}
