package usts.pycro.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import usts.pycro.mybatis.mapper.SelectMapper;
import usts.pycro.mybatis.pojo.User;
import usts.pycro.mybatis.utils.SqlSessionUtil;

import java.util.List;
import java.util.Map;

/**
 * @Author Pycro
 * @Create 2023-03-13  7:52
 * @Description
 * @Version 1.0
 */
public class SelectMapperTest {

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> users = mapper.getAllUser();
        users.forEach(System.out::println);
    }

    @Test
    public void testGetCount() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer res = mapper.getCount();
        System.out.println(res);
    }

    @Test
    public void testGetUserByIdToMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getUserByIdToMap(3);
        // {password=123456, gender=男, id=1, age=23, email=12345@qq.com, username=admin}
        System.out.println(map);
    }

    @Test
    public void testGetAllUserToMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        //List<Map<String, Object>> maps = mapper.getAllUserToMap();// TooManyResultsException
        //maps.forEach(System.out::println);
        /*
        {
            1={password=123456, gender=男, id=1, age=23, email=12345@qq.com, username=admin},
            2={password=123456, gender=女, id=2, age=32, email=123@qq.com, username=root},
            3={password=2333, gender=男, id=3, username=Pycro}
        }
         */
        Map<String, Object> map = mapper.getAllUserToMap();
        System.out.println("------------------------------------");
        System.out.println(map);
    }
}
