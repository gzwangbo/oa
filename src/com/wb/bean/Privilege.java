package com.wb.bean;

import java.util.HashSet;

public class Privilege {
  private int id;
  private String name;
  private String url;
  private String icon;
  private HashSet<Role> roles;
  private HashSet<Privilege> children;
  private Privilege parent;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getIcon() {
	return icon;
}
public void setIcon(String icon) {
	this.icon = icon;
}
public HashSet<Role> getRoles() {
	return roles;
}
public void setRoles(HashSet<Role> roles) {
	this.roles = roles;
}


public HashSet<Privilege> getChildren() {
	return children;
}
public void setChildren(HashSet<Privilege> children) {
	this.children = children;
}
public Privilege getParent() {
	return parent;
}
public void setParent(Privilege parent) {
	this.parent = parent;
}
  
  
}
