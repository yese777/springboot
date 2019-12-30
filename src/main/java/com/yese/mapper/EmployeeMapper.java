package com.yese.mapper;

import com.yese.pojo.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper {

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
    Employee getById(@Param("id") Integer id);

    /**
     * 根据id删除员工
     *
     * @param id
     */
    void deleteById(@Param("id") Integer id);

    /**
     * 修改员工
     *
     * @param employee
     */
    void update(Employee employee);
}
