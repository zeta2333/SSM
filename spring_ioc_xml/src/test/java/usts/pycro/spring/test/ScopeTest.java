package usts.pycro.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import usts.pycro.spring.pojo.Student;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-20 21:43
 */
public class ScopeTest {
    @Test
    public void testScope() {
        // 获取ioc容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-scope.xml");
        // 获取bean
        Student student1 = ioc.getBean(Student.class);
        Student student2 = ioc.getBean(Student.class);
        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());
        System.out.println(student1==student2);
    }
}
