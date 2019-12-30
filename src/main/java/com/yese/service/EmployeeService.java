package com.yese.service;

import com.yese.pojo.Employee;

import java.util.List;

public interface EmployeeService {


    /**
     * 查询所有员工
     *
     * @return
     */
    List<Employee> getAll();

    /**
     * 保存员工
     *
     * @param employee
     */
    void save(Employee employee);

    /**
     * 根据id查询所有员工
     *
     * @param id
     * @return
     */
    Employee getById(Integer id);

    /**
     * 根据id删除员工
     *
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 修改员工
     *
     * @param employee
     */
    void update(Employee employee);
}
