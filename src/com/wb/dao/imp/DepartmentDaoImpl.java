package com.wb.dao.imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.wb.bean.Department;
import com.wb.dao.DepartmentDao;

public class DepartmentDaoImpl implements DepartmentDao{
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
	public void save(Department department) {
		// TODO Auto-generated method stub
		  Transaction ts=getSession().beginTransaction();
		    getSession().save(department);
			
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
	public Department find(int id) {
		// TODO Auto-generated method stub
		
		return (Department)getSession().get(Department.class,id);
	}

	@Override
	public void update(Department department) {
		// TODO Auto-generated method stub
		Transaction ts=getSession().beginTransaction();
	    getSession().update(department);;
		
		ts.commit();
		getSession().flush();
	}

	@Override
	public void delete(int[] ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		List list=getSession().createQuery("from Department").list();
		
		return list;
	}

}
