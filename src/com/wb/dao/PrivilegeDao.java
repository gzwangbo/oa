package com.wb.dao;

import java.util.List;

import com.wb.bean.Privilege;





public interface PrivilegeDao  {
public void save(Privilege privilege);
public void delete(int id);
public Privilege find(int id);
public void update(Privilege privilege);
public void delete(int[] ids);
public List<Privilege> findAll();


}
