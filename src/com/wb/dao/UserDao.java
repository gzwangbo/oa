package com.wb.dao;

import java.util.List;

import com.wb.bean.User;




public interface UserDao  {
public void save(User user);
public void delete(int id);
public User find(int id);
public void update(User user);
public void delete(int[] ids);
public List<User> findAll();


}
