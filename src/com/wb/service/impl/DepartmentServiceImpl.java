package com.wb.service.impl;

import java.util.List;

import org.hibernate.Transaction;

import com.wb.bean.Department;
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

	public void save(Department department) {
		// TODO Auto-generated method stub
		departmentDao.save(department);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		departmentDao.delete(id);
	}

	public Department find(int id) {
		// TODO Auto-generated method stub
		return departmentDao.find(id);
	}

	public void update(Department department) {
		// TODO Auto-generated method stub
		departmentDao.update(department);
	}
	public List findAll(){
		
		return departmentDao.findAll();
	}

	@Override
	public List<Department> findTopList() {
		// TODO Auto-generated method stub
		return departmentDao.getSession().createQuery("from Department d where d.parent.id=null").list();
	}

	@Override
	public List<Department> findChildren(int parentId) {
		// TODO Auto-generated method stub
		return departmentDao.getSession().createQuery("from Department d where d.parent.id=?")
				.setParameter(0,parentId).list();
	}

	
}
