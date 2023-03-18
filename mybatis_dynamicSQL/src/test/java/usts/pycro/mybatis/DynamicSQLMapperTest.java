package usts.pycro.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import usts.pycro.mybatis.mapper.DynamicSQLMapper;
import usts.pycro.mybatis.pojo.Emp;
import usts.pycro.mybatis.utils.SqlSessionUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Pycro
 * @Create 2023-03-14  22:35
 * @Description
 * @Version 1.0
 */
public class DynamicSQLMapperTest {
    @Test
    public void testGetEmpByCondition() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null, "张三", 21, "男");
        List<Emp> emps = mapper.getEmpByCondition(emp);
        emps.forEach(System.out::println);
    }

    @Test
    public void testGetEmpByChoose() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null, "张三", 21, "");
        List<Emp> emps = mapper.getEmpByChoose(emp);
        emps.forEach(System.out::println);
    }

    @Test
    public void testInsertMoreEmp() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null, "小明1", 20, "男");
        Emp emp2 = new Emp(null, "小明2", 20, "男");
        Emp emp3 = new Emp(null, "小明3", 20, "男");
        List<Emp> emps = new ArrayList<>();
        emps.add(emp1);
        emps.add(emp2);
        emps.add(emp3);
        mapper.insertMoreEmp(emps);
    }

    @Test
    public void testDeleteMoreEmp() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Integer[] empIds = new Integer[]{9, 10, 11};
        mapper.deleteMoreEmp(empIds);
    }
}
