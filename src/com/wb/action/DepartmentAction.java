package com.wb.action;

import java.util.List;






import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wb.bean.Department;
import com.wb.service.impl.DepartmentServiceImpl;
import com.wb.util.DepartmentUtils;


public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {

	private DepartmentServiceImpl departmentService;
	private Department department;
	private String parentId;
    
	

	public String getParentId() {
		return parentId;
	}


	public void setParentId(String parentId) {
		this.parentId = parentId;
	}


	public Department getdepartment() {
		return department;
	}


	public void setdepartment(Department department) {
		this.department = department;
	}


	public DepartmentServiceImpl getdepartmentService() {
		return departmentService;
	}


	public void setdepartmentService(DepartmentServiceImpl departmentService) {
		this.departmentService = departmentService;
	}


	public String list(){
 //  System.out.println(parentId);
    List list=null;
    if(parentId==null){
    	
    	list=departmentService.findTopList();
    //	 System.out.println("qqqqq");
    
    }else{
    	
    	list=departmentService
    			.findChildren(Integer.parseInt(parentId));
    	Department parent=departmentService.find(Integer.parseInt(parentId));
    	ActionContext.getContext().put("parent", parent);
    	// System.out.println("wwww");
    }
	ActionContext.getContext().put("list", list);
	return "list";	
	}
	
	public String save(){
		  System.out.println("parent"+parentId);
		  if(parentId==null||parentId.equals("")){
			 // department.setParent(null);
			  departmentService.save(department);
			  System.out.println("holle");
		  }else
	      department.setParent(departmentService.find(Integer.parseInt(parentId)));
	      departmentService.save(department);
	return "tolist";
	}
	public String saveInput(){
	List<Department> topList=departmentService.findTopList();
	List<Department> departments=DepartmentUtils.getAllDepartments(topList);
	ActionContext.getContext().put("departments",departments);
    return "saveInput";
	}
	
	public String delete(){
		//System.out.println("department.getId"+id);
		departmentService.delete(department.getId());
		System.out.println("delete execute");
		return "tolist";
	}
   public String updateInput(){
	   Department department1=departmentService.find(department.getId());
	   System.out.println(department.getName());
	   ActionContext.getContext().getValueStack().push(department1);
	   return "updateInput";
   }	
   public  String update(){
	   departmentService.update(department);
	   return "tolist";
	   
   }


@Override
public Department getModel() {
	// TODO Auto-generated method stub
	if(department==null){
		
		department=new Department();
	}
	return department;
}
}
