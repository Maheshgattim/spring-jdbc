package com.spring.springjdbc.dao;

import java.util.List;

import com.spring.springjdbc.dto.Employee;

public interface EmployeeDao {
	
	List<Employee> findAllEmployees();
	
	void insertEmployee(Employee employee);
	
	Employee getEmployeeById(String id);

}
