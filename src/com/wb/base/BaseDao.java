package com.wb.base;

public interface BaseDao <T> {
  public void save(T t);
  public void delete(Class entity,int id);
  public T find(Class entity,int id);
  public void update(T t);
  
}
