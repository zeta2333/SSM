package usts.pycro.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import usts.pycro.pojo.Employee;
import usts.pycro.service.EmployeeService;

import java.util.List;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-31 14:33
 * 查询所有的员工信息 --> /employee --> get
 * 查询员工分页信息 --> /employee/page/1 --> get
 * 根基id查询某个员工信息 --> /employee/1 --> get
 * 跳转到添加页面 --> /to/add --> get
 * 添加员工信息 --> /employee --> post
 * 修改员工信息 --> /employee --> put
 * 删除员工信息 --> /employee/1 --> delete
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee/page/{pageNum}", method = RequestMethod.GET)
    public String getEmployeePage(@PathVariable("pageNum") Integer pageNum,Model model) {
        // 获取员工的分页信息
        PageInfo<Employee> page = employeeService.getEmployeePage(pageNum);
        // 将分页数据共享到请求域中
        model.addAttribute("page",page);
        //跳转到列表界面
        return "employee_list";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployee(Model model) {
        System.out.println("EmployeeController.getAllEmployee -- called");
        //查询所有的员工信息
        List<Employee> list = employeeService.getAllEmployee();
        //将员工信息共享到请求域中
        model.addAttribute("list", list);
        //跳转到employee_list
        return "employee_list";
    }

}
