package com.wb.base;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>  {

	@Override
	public void save(T t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(t);
	}

	@Override
	public void delete(Class entity,int id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(find(entity, id));
	}

	

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(t);
	}

	@Override
	public T find(Class entity, int id) {
		// TODO Auto-generated method stub
		return (T)getHibernateTemplate().get(entity, id);
	}
  
    

}
