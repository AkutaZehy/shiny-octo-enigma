package com.akutazehy.ssm.service;

import com.akutazehy.ssm.pojo.Employee;

import java.util.List;

/**
 * @author Akuta_Zehy
 * @version 1.0
 */
public interface EmployeeService {

    /**
     * 查询所有的员工信息
     * @return
     */
    List<Employee> getAllEmployee();
}
