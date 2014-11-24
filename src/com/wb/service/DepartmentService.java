package com.wb.service;

import java.util.List;

import com.wb.bean.Department;

public interface DepartmentService {
  public List<Department> findTopList();
  public List<Department> findChildren(int parentId);
}
