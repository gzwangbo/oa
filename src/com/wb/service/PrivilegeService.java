package com.wb.service;

import java.util.List;

import com.wb.bean.Privilege;

public interface PrivilegeService {
  public List<Privilege> findTopList();
  public List<Privilege> findChildren(int parentId);
}
