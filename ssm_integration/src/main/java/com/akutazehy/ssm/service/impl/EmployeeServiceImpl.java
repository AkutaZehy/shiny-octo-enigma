package com.akutazehy.ssm.service.impl;

import com.akutazehy.ssm.mapper.EmployeeMapper;
import com.akutazehy.ssm.pojo.Employee;
import com.akutazehy.ssm.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Akuta_Zehy
 * @version 1.0
 */

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }
    @Override
    public PageInfo<Employee> getEmployeesByPage(Integer pageNum) {
        //开启分页功能
        PageHelper.startPage(pageNum, 4);

        //查询所有员工信息
        List<Employee> list = employeeMapper.getAllEmployee();

        //获取分页相关数据
        PageInfo<Employee> page = new PageInfo<>(list, 5);

        return page;
    }
}
