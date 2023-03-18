package usts.pycro.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import usts.pycro.mybatis.mapper.UserMapper;
import usts.pycro.mybatis.pojo.User;
import usts.pycro.mybatis.utils.SqlSessionUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Pycro
 * @Create 2023-03-11  22:06
 * @Description
 * @Version 1.0
 */
public class ParameterTest {
    @Test
    public void testGetUserByUserName() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByUsername("admin");
        System.out.println("user = " + user);
    }

    @Test
    public void testCheckLogin() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLogin("admin", "123456");
        System.out.println("user = " + user);
    }

    @Test
    public void testCheckLoginByMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username", "admin");
        map.put("password", "123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println("user = " + user);
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null, "root", "123456", 32, "女", "123@qq.com");
        mapper.insertUser(user);
    }

    @Test
    public void testCheckLoginByParam() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLoginByParam("root", "123456");
        System.out.println("user = " + user);
    }
}
