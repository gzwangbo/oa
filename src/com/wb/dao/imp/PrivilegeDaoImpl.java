package com.wb.dao.imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.wb.bean.Privilege;
import com.wb.dao.PrivilegeDao;

public class PrivilegeDaoImpl implements PrivilegeDao{
    private SessionFactory sessionFactory;
    
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public  Session getSession(){
		
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Privilege privilege) {
		// TODO Auto-generated method stub
		  Transaction ts=getSession().beginTransaction();
		    getSession().save(privilege);
			
			ts.commit();
			getSession().flush();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		   Transaction ts=getSession().beginTransaction();
		    getSession().delete(find(id));
			
			ts.commit();
			getSession().flush();
	}

	@Override
	public Privilege find(int id) {
		// TODO Auto-generated method stub
		return (Privilege)getSession().get(Privilege.class,id);
	}

	@Override
	public void update(Privilege privilege) {
		// TODO Auto-generated method stub
		Transaction ts=getSession().beginTransaction();
	    getSession().update(privilege);;
		
		ts.commit();
		getSession().flush();
	}

	@Override
	public void delete(int[] ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Privilege> findAll() {
		// TODO Auto-generated method stub
		List list=getSession().createQuery("from Privilege").list();
		
		return list;
	}

}
