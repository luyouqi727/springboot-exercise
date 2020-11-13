package com.yog.controller;

import com.yog.dao.DeptDao;
import com.yog.dao.EmpDao;
import com.yog.pojo.Department;
import com.yog.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmpController {

    @Autowired
    private EmpDao empDao;

    @Autowired
    private DeptDao deptDao;


    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> all = empDao.getAll();
        model.addAttribute("emps",all);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = deptDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String AddPage(Employee employee){
        System.out.println(employee);
        //添加的操作
        empDao.save(employee);
        return "redirect:/emps";
    }


    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id,Model model){
        Employee employee = empDao.getEmployee(id);
        model.addAttribute("emp",employee);

        Collection<Department> departments = deptDao.getDepartments();
        model.addAttribute("departments",departments);

        return "emp/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        empDao.save(employee);
        return "redirect:/emps";
    }


    @GetMapping("/delEmp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        empDao.delete(id);
        System.out.println(id);
        return "redirect:/emps";

    }
}
