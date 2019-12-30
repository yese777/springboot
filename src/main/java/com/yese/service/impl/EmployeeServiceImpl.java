package com.yese.service.impl;

import com.yese.mapper.EmployeeMapper;
import com.yese.pojo.Employee;
import com.yese.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;


    /**
     * 查询所有员工
     *
     * @return
     */
    @Override
    public List<Employee> getAll() {
        return employeeMapper.getAll();
    }

    /**
     * 保存员工
     *
     * @param employee
     */
    @Override
    public void save(Employee employee) {
        employeeMapper.save(employee);
    }

    /**
     * 根据id查询所有员工
     *
     * @param id
     * @return
     */
    @Override
    public Employee getById(Integer id) {
        return employeeMapper.getById(id);
    }

    /**
     * 根据id删除员工
     *
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        employeeMapper.deleteById(id);
    }

    /**
     * 修改员工
     *
     * @param employee
     */
    @Override
    public void update(Employee employee) {
        employeeMapper.update(employee);
    }
}
