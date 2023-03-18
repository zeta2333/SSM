package usts.pycro.mybatis.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import usts.pycro.mybatis.mapper.EmpMapper;
import usts.pycro.mybatis.pojo.Emp;
import usts.pycro.mybatis.utils.SqlSessionUtil;

import java.util.List;

/**
 * @Author Pycro
 * @Create 2023-03-17  14:26
 * @Description
 * @Version 1.0
 */
public class PageTest {
    /*
    PageInfo{
        pageNum=2, pageSize=5, size=5, startRow=6, endRow=10, total=30, pages=6,
        list=Page{
            count=true, pageNum=2, pageSize=5, startRow=5, endRow=10, total=30, pages=6, reasonable=false, pageSizeZero=false
            }
            [
                Emp{empId=6, empName='a', age=null, gender='null', deptId=null},
                Emp{empId=7, empName='a', age=null, gender='null', deptId=null},
                Emp{empId=8, empName='a', age=null, gender='null', deptId=null},
                Emp{empId=9, empName='a', age=null, gender='null', deptId=null},
                Emp{empId=10, empName='a', age=null, gender='null', deptId=null}
            ],
        prePage=1, nextPage=3, isFirstPage=false, isLastPage=false, hasPreviousPage=true, hasNextPage=true,
        navigatePages=5, navigateFirstPage=1, navigateLastPage=5, navigatepageNums=[1, 2, 3, 4, 5]}
     */

    @Test
    public void testPage(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //查询功能之前开启分页功能
        Page<Object> page = PageHelper.startPage(2, 5);
        List<Emp> list = mapper.selectByExample(null);
        PageInfo<Emp> pageInfo = new PageInfo<>(list,6);
        list.forEach(System.out::println);
        System.out.println(pageInfo);
    }
}
