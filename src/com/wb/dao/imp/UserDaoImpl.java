package com.wb.dao.imp;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.wb.bean.User;
import com.wb.dao.UserDao;

public class UserDaoImpl implements UserDao{
   private SessionFactory SessionFactory;
   
	public SessionFactory getSessionFactory() {
	return SessionFactory;
}
	public Session getSession(){
		
		return SessionFactory.getCurrentSession();
	}

public void setSessionFactory(SessionFactory sessionFactory) {
	SessionFactory = sessionFactory;
}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		Transaction transction=getSession().beginTransaction();
		getSession().save(user);
		transction.commit();
		getSession().close();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Transaction transction=getSession().beginTransaction();
		getSession().save(find(id));
		transction.commit();
		getSession().close();
	}

	@Override
	public User find(int id) {
		// TODO Auto-generated method stub
		return (User) getSession().get(User.class,id);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		Transaction transction=getSession().beginTransaction();
		getSession().update(user);
		transction.commit();
		getSession().close();
	}

	@Override
	public void delete(int[] ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from User").list();
	}

}
