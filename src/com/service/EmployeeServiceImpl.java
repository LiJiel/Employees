package com.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dao.EmployeeDao;
import com.entity.Employee;
import com.util.MyBatisUtils;

public class EmployeeServiceImpl implements EmployeeService{

	@Override
	public void resgiter(Employee employee) {
		try {
			EmployeeDao employeeDao=(EmployeeDao) MyBatisUtils.getMapper(EmployeeDao.class);
			employeeDao.SaveEmployee(employee);
			MyBatisUtils.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MyBatisUtils.rollback();
		}
		
		
	}

	@Override
	public boolean login(Employee employee) {
		try {
			EmployeeDao employeeDao=(EmployeeDao) MyBatisUtils.getMapper(EmployeeDao.class);
			Employee employee2=employeeDao.queryEmp(employee);
			if(employee2.getUsername()!=null){
				System.out.println("µÇÂ½³É¹¦");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
