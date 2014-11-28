package com.wb.service.impl;


import java.util.List;

import com.wb.bean.User;
import com.wb.dao.imp.UserDaoImpl;
import com.wb.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDaoImpl userDao;
	
	public UserDaoImpl getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}
	public void save(User user){
		
		userDao.save(user);
	}
	public void delete(int id){
		
		userDao.delete(id);
	}
	public User find(int id){
		return userDao.find(id);
		
	}
	public void update(User user){
		
		userDao.update(user);
	}
	
	public List<User> findAll(){
		
		return userDao.findAll();
	}
}
