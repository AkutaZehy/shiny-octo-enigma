package com.akutazehy.ssm.controller;

import com.akutazehy.ssm.pojo.Employee;
import com.akutazehy.ssm.service.EmployeeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Akuta_Zehy
 * @version 1.0
 * Description:
 * 查询所有的员工信息 --> /employee --> get
 * 查询员工的分页信息 --> /employee/page/1 --> get
 * 根据id查询员工信息 --> /employee/1 --> get
 * 跳转到添加页面 --> /to/add --> get
 * 添加员工信息 --> /employee --> post
 * 修改员工信息 --> /employee --> put
 * 删除员工信息 --> /employee/1 --> delete
 */

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployee(Model model) {
        //查询所有的员工信息
        List<Employee> list = employeeService.getAllEmployee();
        //将员工信息在请求域中共享
        model.addAttribute("list", list);
        //跳转到employee_list.html
        return "employee_list";
    }



    @RequestMapping(value = "employee/page/{pageNumber}", method = RequestMethod.GET)
    public String getAllEmployeeByPage(@PathVariable(value = "pageNumber") Integer pageNum,
                                       Model model) {
        //获取分页信息
        if(null == pageNum)
            pageNum = 1;
        PageInfo<Employee> page =  employeeService.getEmployeesByPage(pageNum);

        //将分页数据共享到请求域中
        model.addAttribute("page", page);

        //跳转到employee_list.html
        return "employee_page";
    }

    /*@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable(value = "id") String empId) {
        return employeeService.getEmployeeById(empId);
    }*/
}
