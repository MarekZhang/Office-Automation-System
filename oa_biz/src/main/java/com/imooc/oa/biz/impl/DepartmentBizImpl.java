package com.imooc.oa.biz.impl;

import com.imooc.oa.biz.DepartmentBiz;
import com.imooc.oa.dao.DepartmentDao;
import com.imooc.oa.entity.Department;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

@Service("departmentBiz")
public class DepartmentBizImpl implements DepartmentBiz {
  @Resource(name="departmentDao")
  private DepartmentDao departmentDao;

  public void add(Department department) {
    departmentDao.insert(department);
  }

  public void edit(Department department) {
    departmentDao.update(department);
  }

  public void remove(String sn) {
    departmentDao.delete(sn);
  }

  public Department get(String sn) {
    return departmentDao.select(sn);
  }

  public List<Department> getAll() {
    return departmentDao.selectAll();
  }
}
