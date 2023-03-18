package usts.pycro.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import usts.pycro.mybatis.mapper.EmpMapper;
import usts.pycro.mybatis.pojo.Emp;
import usts.pycro.mybatis.utils.SqlSessionUtil;

/**
 * @Author Pycro
 * @Create 2023-03-16  10:17
 * @Description
 * @Version 1.0
 */
public class MBGTest {
    @Test
    public void testMBG() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //根据id查询
        //Emp emp = mapper.selectByPrimaryKey(1);
        //System.out.println(emp);
        //查询所有数据
        //List<Emp> list = mapper.selectByExample(null);
        //list.forEach(System.out::println);
        //条件查询
        //EmpExample example = new EmpExample();
        //example.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThanOrEqualTo(20);
        //example.or().andGenderEqualTo("男");
        //List<Emp> list = mapper.selectByExample(example);
        //list.forEach(System.out::println);

        Emp emp = new Emp(1,"張三",null,"女");
        //测试普通修改
        //mapper.updateByPrimaryKey(emp);
        //测试选择性修改
        mapper.updateByPrimaryKeySelective(emp);
    }

}
