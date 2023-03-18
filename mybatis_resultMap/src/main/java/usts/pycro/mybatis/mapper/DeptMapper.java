package usts.pycro.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import usts.pycro.mybatis.pojo.Dept;

/**
 * @Author Pycro
 * @Create 2023-03-13  11:33
 * @Description
 * @Version 1.0
 */
public interface DeptMapper {
    /**
     * 分步查询员工以及所对应的部门信息：第二步
     *
     * @param deptId
     * @return
     */
    Dept getEmpAndDeptByStepTwo(@Param("deptId") Integer deptId);

    /**
     * 查询部门以及员工信息
     * @param deptId
     * @return
     */
    Dept getDeptAndEmp(@Param("deptId") Integer deptId);

    /**
     * 通过分步查询，查询部门以及部门中的员工信息：第一步
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByStepOne(@Param("deptId") Integer deptId);
}
