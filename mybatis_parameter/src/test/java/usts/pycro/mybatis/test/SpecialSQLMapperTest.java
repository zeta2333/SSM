package usts.pycro.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import usts.pycro.mybatis.mapper.SpecialSQLMapper;
import usts.pycro.mybatis.pojo.User;
import usts.pycro.mybatis.utils.SqlSessionUtil;

import java.util.List;

/**
 * @Author Pycro
 * @Create 2023-03-13  8:41
 * @Description
 * @Version 1.0
 */
public class SpecialSQLMapperTest {
    @Test
    public void testGetUserByLike() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> users = mapper.getUserByLike("a");
        users.forEach(System.out::println);
    }

    @Test
    public void testDeleteMoreUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        mapper.deleteMoreUser("9,10");
    }

    @Test
    public void testGetUserList() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> users = mapper.getUserList("t_user");
        users.forEach(System.out::println);
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        User user = new User(null, "xiaoming", "123456", 23, "男", "21345@qq.com");
        mapper.insertUser(user);
        System.out.println(user);

    }
}
