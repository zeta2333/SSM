package usts.pycro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import usts.pycro.dao.EmployeeDao;
import usts.pycro.pojo.Employee;

import java.util.Collection;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-29 9:53
 * 查询所有的员工信息 --> /employee --> get
 * 跳转到添加页面 --> /to/add --> get
 * 添加员工信息 --> /employee --> post
 * 跳转到修改页面 --> /employee/1 --> get
 * 修改员工信息 --> /employee --> put
 * 删除员工信息 --> /employee/1 --> delete
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employee")
    public String getAllEmployee(Model model) {
        //获取所有的员工信息
        Collection<Employee> employees = employeeDao.getAll();
        //将所有的员工信息在请求域中共享
        model.addAttribute("employees", employees);
        //跳转到列表页面
        return "employee_list";
    }

    @PostMapping("/employee")
    public String addEmployee(Employee employee) {
        //保存员工信息
        employeeDao.save(employee);
        //重定向到列表功能：/employee
        return "redirect:/employee";
    }

    @GetMapping("/employee/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model) {
        //根据id查询员工信息
        Employee employee = employeeDao.get(id);
        //将员工信息共享到请求域中
        model.addAttribute("employee", employee);
        //跳转到employee_update.html
        return "employee_update";
    }

    @PutMapping("/employee")
    public String updateEmployee(Employee employee) {
        //修改员工信息
        employeeDao.save(employee);
        //重定向到列表功能：/employee
        return "redirect:/employee";
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        //删除指定id的员工
        employeeDao.delete(id);
        //重定向到list界面
        return "redirect:/employee";
    }
}
