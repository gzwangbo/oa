package com.wb.service.impl;

import java.util.List;

import org.hibernate.Transaction;

import com.wb.bean.Privilege;

import com.wb.dao.imp.PrivilegeDaoImpl;

import com.wb.service.PrivilegeService;

public class PrivilegeServiceImpl implements PrivilegeService{

	private PrivilegeDaoImpl privilegeDao;

	public PrivilegeDaoImpl getPrivilegeDao() {
		return privilegeDao;
	}

	public void setPrivilegeDao(PrivilegeDaoImpl privilegeDao) {
		this.privilegeDao = privilegeDao;
	}

	public void save(Privilege privilege) {
		// TODO Auto-generated method stub
		privilegeDao.save(privilege);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		privilegeDao.delete(id);
	}

	public Privilege find(int id) {
		// TODO Auto-generated method stub
		return privilegeDao.find(id);
	}

	public void update(Privilege privilege) {
		// TODO Auto-generated method stub
		privilegeDao.update(privilege);
	}
	public List findAll(){
		
		return privilegeDao.findAll();
	}

	@Override
	public List<Privilege> findTopList() {
		// TODO Auto-generated method stub
		return privilegeDao.getSession().createQuery("from Privilege d where d.parent.id=null").list();
	}

	@Override
	public List<Privilege> findChildren(int parentId) {
		// TODO Auto-generated method stub
		return privilegeDao.getSession().createQuery("from Privilege d where d.parent.id=?")
				.setParameter(0,parentId).list();
	}

	
}
