package com.spring.springjdbc.bussiness;

import com.spring.springjdbc.dto.Employee;

public interface EmployeeBussiness {

	void printAllEmploeeHikes();
	
	void insertEmployee(Employee employee);
	
	Employee getEmployeeById(String id);
}
