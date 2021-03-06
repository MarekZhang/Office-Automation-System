package com.imooc.oa.dao;

import com.imooc.oa.entity.Department;
import com.imooc.oa.entity.Employee;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("employeeDao")
public interface EmployeeDao {
  void insert(Employee employee);

  void update(Employee employee);

  void delete(String sn);

  Employee select(String sn);

  List<Employee> selectAll();

  List<Employee> selectByDepAndPos(@Param("depSn")String depSn, @Param("pos")String pos);
}
