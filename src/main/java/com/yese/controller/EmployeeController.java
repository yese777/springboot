package com.yese.controller;

import com.yese.pojo.Department;
import com.yese.pojo.Employee;
import com.yese.service.DepartmentService;
import com.yese.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;
    
    //查询所有员工并跳转列表页面
    @GetMapping("/emps")
    public String list(Model model) {
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    //跳转到添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        //查出所有的部门，提供选择
        List<Department> departments = departmentService.getAll();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //添加员工
    @PostMapping("/emp")
    //接收前端传递的参数，自动封装成为对象[要求前端传递的参数名，和属性名一致]
    public String addEmp(Employee employee){
        System.out.println(employee);
        employeeService.save(employee); //保存员工信息
        //添加完成回到列表页面,此处是一个请求,可以使用redirect或者forward
        return "redirect:/emps";
    }

    //跳转到员工修改页面,将当前员工数据回显
    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer id, Model model){
        //根据id查出来员工
        Employee employee = employeeService.getById(id);
        //将员工信息返回页面
        model.addAttribute("emp",employee);
        //查出所有的部门，提供修改选择
        List<Department> departments = departmentService.getAll();
        model.addAttribute("depts",departments);
        //跳转修改页面(add是修改和添加二合一的页面)
        return "emp/update";
    }

    //修改员工(表单需要包含员工id)
    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeService.update(employee);
        //回到员工列表页面
        return "redirect:/emps";
    }

    //删除员工
    @GetMapping("/delEmp/{id}")
    public String delEmp(@PathVariable("id") Integer id){
        employeeService.deleteById(id);
        return "redirect:/emps";
    }

}