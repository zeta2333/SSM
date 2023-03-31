package usts.pycro.service;

import com.github.pagehelper.PageInfo;
import usts.pycro.pojo.Employee;

import java.util.List;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-31 14:56
 */
public interface EmployeeService {
    /**
     * 查询所有员工信息
     * @return
     */
    List<Employee> getAllEmployee();

    /**
     * 获取员工的分页信息
     * @param pageNum
     * @return
     */
    PageInfo<Employee> getEmployeePage(Integer pageNum);
}
