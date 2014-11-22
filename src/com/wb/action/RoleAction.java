package com.wb.action;

import java.util.List;



import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wb.bean.Role;
import com.wb.service.impl.RoleServiceImpl;

public class RoleAction extends ActionSupport implements ModelDriven<Role> {

	private RoleServiceImpl roleService;
	private Role role;
	


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public RoleServiceImpl getRoleService() {
		return roleService;
	}


	public void setRoleService(RoleServiceImpl roleService) {
		this.roleService = roleService;
	}


	public String list(){
    List list=roleService.findAll();
	ActionContext.getContext().put("list", list);
	return "list";	
	}
	
	public String save(){
	System.out.println("name"+role.getName());
	System.out.println("des"+role.getDescription());
	roleService.save(role);
	return "tolist";
	}
	public String saveInput(){
    return "saveInput";
	}
	
	public String delete(){
		//System.out.println("role.getId"+id);
		roleService.delete(role.getId());
		System.out.println("delete execute");
		return "tolist";
	}
   public String updateInput(){
	   Role role1=roleService.find(role.getId());
	   System.out.println(role.getName());
	   ActionContext.getContext().getValueStack().push(role1);
	   return "updateInput";
   }	
   public  String update(){
	   roleService.update(role);
	   return "tolist";
	   
   }


@Override
public Role getModel() {
	// TODO Auto-generated method stub
	if(role==null){
		
		role=new Role();
	}
	return role;
}
}
