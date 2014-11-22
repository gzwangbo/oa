package com.wb.dao.imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.wb.bean.Role;
import com.wb.dao.RoleDao;




/**
 * @author wangbo
 *
 */
public class RoleDaoImpl implements RoleDao {
   private SessionFactory sessionFactory ;
  

   
public Session getSession(){
	
	return sessionFactory.getCurrentSession();
}


public SessionFactory getSessionFactory() {
	return sessionFactory;
}

public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}



public void save(Role role) {
	// TODO Auto-generated method stub
    Transaction ts=getSession().beginTransaction();
    getSession().save(role);
	
	ts.commit();
	getSession().flush();
	
}

public void delete(int id) {
	// TODO Auto-generated method stub
	Transaction ts=getSession().beginTransaction();
	getSession().delete(find(id));
	//
	ts.commit();
	getSession().flush();
}  



public void delete(int[] ids) {
	// TODO Auto-generated method stub
	for(int i=0;i<ids.length;i++){
		delete(ids[i]);
	}
}



public Role find(int id) {
	// TODO Auto-generated method stub
	return (Role) getSession().get(Role.class, id);
	
}

public void update(Role role) {
	// TODO Auto-generated method stub
	
	Transaction ts=getSession().beginTransaction();
	getSession().update(role);
	//getSession().flush();
	ts.commit();
	getSession().flush();
	
}




public List<Role> findAll() {
	// TODO Auto-generated method stub
	return getSession().createQuery("from Role").list();
}








}
