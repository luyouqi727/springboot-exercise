package com.yog.dao;

import com.yog.pojo.Department;
import com.yog.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmpDao {

    private static Map<Integer, Employee> employees = null;

    @Autowired
    DeptDao deptDao;

    static{
        employees = new HashMap<Integer,Employee>();

        employees.put(101,new Employee(101,"aa","24548878@qq.com",1,DeptDao.getDepartmentById(101)));
        employees.put(102,new Employee(102,"bb","77548878@qq.com",1,DeptDao.getDepartmentById(102)));
        employees.put(103,new Employee(103,"cc","544548878@qq.com",1,DeptDao.getDepartmentById(103)));
        employees.put(104,new Employee(104,"dd","88548878@qq.com",1,DeptDao.getDepartmentById(104)));
        employees.put(105,new Employee(105,"ee","99548878@qq.com",1,DeptDao.getDepartmentById(105)));
    }

    //自增参数
    private static Integer initId = 1006;

    //增加一个员工
    public void save(Employee employee){
        if(employee.getId()==null){
            employee.setId(initId++);
        }

        employee.setDepartment(DeptDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);
    }

    //查询全部员工
    public Collection<Employee> getAll(){
        return employees.values();
    }

    //通过id查询员工
    public Employee getEmployee(Integer id){
        return employees.get(id);
    }

    //删除员工
    public void delete(Integer id){
        employees.remove(id);
    }
}
