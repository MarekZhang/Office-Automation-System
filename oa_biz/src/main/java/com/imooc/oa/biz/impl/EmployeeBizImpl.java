package com.imooc.oa.biz.impl;

import com.imooc.oa.biz.DepartmentBiz;
import com.imooc.oa.biz.EmployeeBiz;
import com.imooc.oa.dao.DepartmentDao;
import com.imooc.oa.dao.EmployeeDao;
import com.imooc.oa.entity.Department;
import com.imooc.oa.entity.Employee;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

@Service("employeeBiz")
public class EmployeeBizImpl implements EmployeeBiz {
  @Resource(name="employeeDao")
  EmployeeDao employeeDao;

  public void add(Employee employee) {
    //set default password
    employee.setPassword("000000");
    employeeDao.insert(employee);
  }

  public void edit(Employee employee) {
    employeeDao.update(employee);
  }

  public void remove(String sn) {
    employeeDao.delete(sn);
  }

  public Employee get(String sn) {
    return employeeDao.select(sn);
  }

  public List<Employee> getAll() {
    return employeeDao.selectAll();
  }
}
