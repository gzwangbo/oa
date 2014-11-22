package com.wb.service.impl;

import java.util.List;

import org.hibernate.Transaction;

import com.wb.bean.Role;
import com.wb.dao.imp.DepartmentDaoImpl;
import com.wb.dao.imp.RoleDaoImpl;
import com.wb.service.DepartmentService;
import com.wb.service.RoleService;

public class DepartmentServiceImpl implements DepartmentService{

	private DepartmentDaoImpl departmentDao;

	public DepartmentDaoImpl getDepartmentDao() {
		return departmentDao;
	}

	public void setDepartmentDao(DepartmentDaoImpl departmentDao) {
		this.departmentDao = departmentDao;
	}

	
	
}
