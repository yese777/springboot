package com.yese.service.impl;

import com.yese.mapper.DepartmentMapper;
import com.yese.pojo.Department;
import com.yese.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;


    /**
     * 查询所有部门
     *
     * @return
     */
    @Override
    public List<Department> getAll() {
        return departmentMapper.getAll();
    }
}
