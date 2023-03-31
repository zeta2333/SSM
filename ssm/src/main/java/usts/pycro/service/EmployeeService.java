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

    /**
     * 根基id查询员工信息
     * @param id
     * @return
     */
    Employee getEmployeeById(Integer id);

    /**
     * 添加员工信息
     * @param employee
     */
    void saveEmployee(Employee employee);

    /**
     * 修改员工信息
     * @param employee
     */
    void updateEmployee(Employee employee);

    /**
     * 根据id删除员工
     * @param id
     */
    void deleteEmployee(Integer id);
}
