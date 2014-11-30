package com.wb.action;

import java.util.HashSet;
import java.util.List;















import org.apache.commons.codec.digest.DigestUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wb.bean.Department;
import com.wb.bean.Role;
import com.wb.bean.User;
import com.wb.service.DepartmentService;
import com.wb.service.impl.DepartmentServiceImpl;
import com.wb.service.impl.RoleServiceImpl;
import com.wb.service.impl.UserServiceImpl;
import com.wb.util.DepartmentUtils;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private UserServiceImpl userService;
	private User user;
	private DepartmentServiceImpl departmentService;
	private RoleServiceImpl roleService;
    private int[] roleId;
    private int departmentId;
    
	

	


	
	public int[] getRoleId() {
		return roleId;
	}


	public void setRoleId(int[] roleId) {
		this.roleId = roleId;
	}


	public int getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}


	public RoleServiceImpl getRoleService() {
		return roleService;
	}


	public void setRoleService(RoleServiceImpl roleService) {
		this.roleService = roleService;
	}


	public DepartmentServiceImpl getDepartmentService() {
		return departmentService;
	}


	public void setDepartmentService(DepartmentServiceImpl departmentService) {
		this.departmentService = departmentService;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public UserServiceImpl getUserService() {
		return userService;
	}


	public void setUserService(UserServiceImpl userService) {
		this.userService = userService;
	}


	public String list(){
 //  System.out.println(parentId);
    List<User> list=userService.findAll();
    System.out.println("lsit");
    for(User user:list){
    	
    System.out.println(user.getName());
   for(Role role:user.getRoles()){
			  
			  System.out.println("ww"+role.getName());
		  }
    }
    System.out.println("eeeeee");
	ActionContext.getContext().put("list", list);
	return "list";	
	}
	
	public String save(){
		  Department department =departmentService.find(departmentId);
		  List<Role> roles=roleService.find(roleId);
		
	      user.setDepartment(department);
	      HashSet<Role> h=new HashSet<Role>(roles);
        for(Role role:h){
			  
			  System.out.println(role.getName());
		  }
	      
	      user.setRoles(new HashSet<Role>(roles));
	      
	      user.setPassword(DigestUtils.md5Hex("666666"));
	
	      userService.save(user);
	      return "tolist";
	}
	
	
	public String saveInput(){
	List<Department> topList=departmentService.findTopList();
	List<Department> departments=DepartmentUtils.getAllDepartments(topList);
	List<Role> roles=roleService.findAll();
	ActionContext.getContext().put("departments", departments);
	ActionContext.getContext().put("roles", roles);
    return "saveInput";
	}
	
	public String delete(){
		//System.out.println("User.getId"+id);
		userService.delete(user.getId());
		System.out.println("delete execute");
		return "tolist";
	}
   public String updateInput(){
	   User user1=userService.find(user.getId());
	   
	   ActionContext.getContext().getValueStack().push(user1);
	   return "updateInput";
   }	
   public  String update(){
	   userService.update(user);
	   return "tolist";
	   
   }


@Override
public User getModel() {
	// TODO Auto-generated method stub
	if(user==null){
		
		user=new User();
	}
	return user;
}
}
