package com.wb.action;

import java.util.List;








import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wb.bean.Privilege;
import com.wb.service.impl.DepartmentServiceImpl;
import com.wb.service.impl.PrivilegeServiceImpl;



public class PrivilegeAction extends ActionSupport implements ModelDriven<Privilege> {

	private PrivilegeServiceImpl privilegeService;
	private Privilege privilege;
	private String parentId;
    
	

	public String getParentId() {
		return parentId;
	}


	public void setParentId(String parentId) {
		this.parentId = parentId;
	}


	public Privilege getdepartment() {
		return privilege;
	}


	public void setdepartment(Privilege privilege) {
		this.privilege = privilege;
	}


	public PrivilegeServiceImpl getdepartmentService() {
		return privilegeService;
	}


	public void setdepartmentService(DepartmentServiceImpl departmentService) {
		this.privilegeService = privilegeService;
	}


	public String list(){
    List list=null;
    if(parentId==null){
    	
    	list=privilegeService.findTopList();
    
    }else{
    	
    	list=privilegeService
    			.findChildren(Integer.parseInt(parentId));
    	Privilege parent=privilegeService.find(Integer.parseInt(parentId));
    	ActionContext.getContext().put("parent", parent);
    	
    }
	ActionContext.getContext().put("list", list);
	return "list";	
	}
	
	public String save(){
		privilege.setParent(privilegeService.find(Integer.parseInt(parentId)));
		privilegeService.save(privilege);
	return "tolist";
	}

	

  

public Privilege getModel() {
	// TODO Auto-generated method stub
	if(privilege==null){
		
		privilege=new Privilege();
	}
	return privilege;
}
}
