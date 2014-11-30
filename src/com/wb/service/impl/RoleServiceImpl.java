package com.wb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;

import com.wb.bean.Role;
import com.wb.dao.imp.RoleDaoImpl;
import com.wb.service.RoleService;

public class RoleServiceImpl implements RoleService{

	private RoleDaoImpl roleDao;

	public RoleDaoImpl getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDaoImpl roleDao) {
		this.roleDao = roleDao;
	}
	

public void save(Role role) {
	// TODO Auto-generated method stub
   roleDao.save(role);
	
	
}

public void delete(int id) {
	// TODO Auto-generated method stub
	
	roleDao.delete(id);
}



public void delete(int[] ids) {
	// TODO Auto-generated method stub
	roleDao.delete(ids);
}



public Role find(int id) {
	// TODO Auto-generated method stub
	return roleDao.find(id);
	
}

public List<Role> find(int [] id) {
	// TODO Auto-generated method stub
	List<Role> list=new ArrayList<Role>();
	for(int i=0;i<id.length;i++){
		
		Role role=find(id[i]);
		list.add(role);
		
	}
	
	return list;
	
	
}

public void update(Role role) {
	// TODO Auto-generated method stub
	
	roleDao.update(role);
	
	
}




public List<Role> findAll() {
	// TODO Auto-generated method stub
	return roleDao.findAll();
}

	
}
