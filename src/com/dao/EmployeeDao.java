package com.dao;

import com.entity.Employee;

public interface EmployeeDao {
	public void SaveEmployee(Employee employee);
	public Employee queryEmp(Employee employee);
}
