package com.action;

import com.entity.Employee;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.service.EmployeeService;
import com.service.EmployeeServiceImpl;

public class EmployeeAction extends ActionSupport{
	private Employee employee;
	private EmployeeService employeeService=new EmployeeServiceImpl();
	
	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String registerEm(){
		employeeService.resgiter(employee);
		return "register";
	}
	
	public String loginEm(){
		boolean login=employeeService.login(employee);
		if(login){
			ValueStack vs=ActionContext.getContext().getValueStack();
			vs.setValue("#session.username", employee.getUsername());
			return "success";
		}
		else return "fail";
	}
}
