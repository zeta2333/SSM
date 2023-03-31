package usts.pycro.mapper;

import usts.pycro.pojo.Employee;

import java.util.List;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-31 15:08
 */
public interface EmployeeMapper {
    /**
     * 获取所有员工信息
     * @return
     */
    List<Employee> getAllEmployee();
}
