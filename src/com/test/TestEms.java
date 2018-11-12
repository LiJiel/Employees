package com.test;

import java.util.List;

import org.junit.Test;






import com.entity.Employee;
import com.entity.Show;
import com.service.EmployeeService;
import com.service.EmployeeServiceImpl;
import com.service.ShowService;
import com.service.ShowServiceImpl;

public class TestEms {
	@Test
	public void register(){
		EmployeeService employeeService=new EmployeeServiceImpl();
		Employee employee=new Employee();
		employee.setUsername("aa");
		employee.setRealname("aa");
		employee.setPassword("456");
		employee.setSex("Å®");
		employeeService.resgiter(employee);
	}
	
	@Test
	public void login(){
		EmployeeService employeeService=new EmployeeServiceImpl();
		Employee employee=new Employee();
		employee.setUsername("Rose");
		employee.setPassword("123");
		
		boolean login=employeeService.login(employee);
		if(login){
			System.out.println("µÇÂ½³É¹¦");
		}else{
			System.out.println("µÇÂ½Ê§°Ü");
		}
		
	}
	
	@Test
	public void queryAll(){
		ShowService showService=new ShowServiceImpl();
		List<Show> lists=showService.queryEmployees();
		for(Show show:lists){
			System.out.println(show);
		}
	}
	
	@Test 
	public void delete(){
		ShowService showService=new ShowServiceImpl();
		showService.delete(1);
	} 
	
	@Test
	public void insert(){
		ShowService showService=new ShowServiceImpl();
		Show show =new Show();
		show.setName("ee");
		show.setSalary(2000);
		show.setAge(20);
		showService.insert(show);
	}
	
	@Test
	public void update(){
		ShowService showService=new ShowServiceImpl();
		Show show=new Show();
		show.setId(2);
		show.setName("yy");
		show.setSalary(2000);
		show.setAge(20);
		showService.update(show);
		
	}
}
