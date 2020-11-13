package com.yog.dao;

import com.yog.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DeptDao {

    //模拟数据库中的数据
    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<Integer, Department>();

        departments.put(101,new Department(101,"教学部"));
        departments.put(102,new Department(102,"运营部"));
        departments.put(103,new Department(103,"后勤部"));
        departments.put(104,new Department(104,"开发部"));
        departments.put(105,new Department(105,"执行部"));
    }

    //获得所有部门信息
    public static Collection<Department> getDepartments(){
        return departments.values();
    }

    //根据id获取部门信息
    public static Department getDepartmentById(Integer id){
        return departments.get(id);
    }


}
