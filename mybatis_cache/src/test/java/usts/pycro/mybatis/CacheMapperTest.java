package usts.pycro.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import usts.pycro.mybatis.mapper.CacheMapper;
import usts.pycro.mybatis.pojo.Emp;
import usts.pycro.mybatis.utils.SqlSessionUtil;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author Pycro
 * @Create 2023-03-16  8:37
 * @Description
 * @Version 1.0
 */
public class CacheMapperTest {
    /**
     * MyBatis的一级缓存：
     * MyBatis的一级缓存是sqlSession级别的，即通过同一个sqlSession查询的数据会被缓存
     * 当再次使用同一个sqlSession查询同一条数据时，会从缓存中获取，不会再访问数据库
     * MyBatis的一级缓存是默认开启的
     * 使一级缓存失效的四种情况：
     * 1.不同的sqlSession对应不同的一级缓存
     * 2.查询条件不同时
     * 3.在两次查询中进行了任意的增删改操作（由于增删改操作会引起数据库内容的变化，为了使得查询的数据真实，干脆清空缓存，再次从数据库中查询）
     * 4.手动清空缓存
     * <p>
     * MyBatis的二级缓存：
     * MyBatis的二级缓存是sqlSessionFactory级别的，即通过同一个sqlSessionFactory所获取的sqlSession
     * 查询的数据会被缓存，当再次通过同一个sqlSessionFactory所获取的sqlSession查询相同的数据时，
     * 会从缓存中获取，不会再访问数据库
     * MyBatis二级缓存开启的条件（4个）：
     * 1.在核心配置文件中，设置全局配置属性cacheEnabled="true"，默认为true，不需要设置
     * 2.在映射文件（xxxMapper.xml）中设置标签<cache/>
     * 3.二级缓存必须在sqlSession关闭或提交之后有效
     * 4.查询的数据所转换的实体类类型必须实现序列化的接口
     * 使二级缓存失效的情况：
     * 两次查询之间执行了任意的增删改，会使一级缓存和二级缓存同时失效
     */

    @Test
    public void testCache() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpByEmpId(1);
        System.out.println(emp1);
        sqlSession1.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp2 = mapper2.getEmpByEmpId(1);
        System.out.println(emp2);
        sqlSession2.close();
    }

    @Test
    public void testGetEmpByEmpId() {
        SqlSession sqlSession1 = SqlSessionUtil.getSqlSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        //查询id为1的员工信息
        Emp emp1 = mapper1.getEmpByEmpId(1);
        System.out.println(emp1);

        //添加一条信息
        //Emp insertEmp = new Emp(null, "老马", 22, "男");
        //mapper1.insertEmp(insertEmp);

        //手动清空缓存
        sqlSession1.clearCache();

        //再次查询id为1的员工信息
        Emp emp2 = mapper1.getEmpByEmpId(1);
        System.out.println(emp2);

        //不同的sqlSession
        //SqlSession sqlSession2 = SqlSessionUtil.getSqlSession();
        //CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        //Emp emp3 = mapper2.getEmpByEmpId(1);
        //System.out.println(emp3);

    }

}
