package com.wb.dao;

import java.util.List;

import com.wb.bean.Department;





public interface DepartmentDao  {
public void save(Department department);
public void delete(int id);
public Department find(int id);
public void update(Department department);
public void delete(int[] ids);
public List<Department> findAll();


}
