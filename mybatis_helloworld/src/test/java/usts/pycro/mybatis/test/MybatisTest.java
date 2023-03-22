package usts.pycro.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import usts.pycro.mybatis.mapper.UserMapper;
import usts.pycro.mybatis.pojo.User;
import usts.pycro.mybatis.utils.SqlSessionUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author Pycro
 * @Create 2023-03-11  19:39
 * @Description
 * @Version 1.0
 */
public class MybatisTest {
    @Test
    public void testInsert() throws IOException {
        //    获取核心配置文件的输入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //    获取sqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //    获取sqlSession对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //    获取sql的会话对象sqlSession（不会自动提交事务），是mybatis提供的操作数据库的对象
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //    获取sql的会话对象sqlSession（会自动提交事务），是mybatis提供的操作数据库的对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //    获取UserMapper的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //    调用mapper接口中的方法，实现添加用户信息的功能
        List<User> result = mapper.getAllUser();
        //调用sqlSession中的具体方法实现对数据库的操作
        //int result = sqlSession.insert("usts.pycro.mybatis.mapper.UserMapper.insertUser");
        System.out.println("结果：" + result);
        //提交事务
        //sqlSession.commit();
        //关闭 sqlSession
        sqlSession.close();
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser();
        sqlSession.close();
    }

    @Test
    public void testDelete() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser();
        sqlSession.close();
    }

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById();
        System.out.println(user);
    }

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getAllUser();
        users.forEach(System.out::println);
    }
}