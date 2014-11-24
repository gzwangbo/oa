package com.wb.dao;

import java.util.List;

import com.wb.bean.Role;




public interface RoleDao  {
public void save(Role role);
public void delete(int id);
public Role find(int id);
public void update(Role role);
public void delete(int[] ids);
public List<Role> findAll();


}
