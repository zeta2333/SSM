package usts.pycro.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import usts.pycro.mybatis.pojo.Emp;

/**
 * @Author Pycro
 * @Create 2023-03-16  8:34
 * @Description
 * @Version 1.0
 */
public interface CacheMapper {

    /**
     * 根基员工id查询员工信息
     * @param empId
     * @return
     */
    Emp getEmpByEmpId(@Param("empId") Integer empId);

    /**
     * 添加员工信息
     * @param emp
     */
    void insertEmp(@Param("emp") Emp emp);
}
