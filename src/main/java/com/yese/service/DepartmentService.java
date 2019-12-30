package com.yese.service;

import com.yese.pojo.Department;

import java.util.List;

public interface DepartmentService {

    /**
     * 查询所有部门
     * @return
     */
    List<Department> getAll();
}
