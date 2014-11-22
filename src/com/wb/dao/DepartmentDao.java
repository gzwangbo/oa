package com.wb.dao;

import com.wb.bean.Department;





public interface DepartmentDao  {
public void save(Department department);
public void delete(int id);
public Department find(int id);
public void update(Department department);
public void delete(int[] ids);


}
