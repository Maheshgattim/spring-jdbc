package com.spring.springjdbc.bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.springjdbc.dao.EmployeeDao;
import com.spring.springjdbc.dto.Employee;
@Component
public class EmployeeBussinessImpl implements EmployeeBussiness {
	@Autowired
	private EmployeeDao employeeDao;
	
	

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}



	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}



	public void printAllEmploeeHikes() {

		List<Employee> employees = employeeDao.findAllEmployees();	
		
		if(employees!=null)
		{
			for(Employee employee : employees)
			{
				if(employee.getExp()>15)
				{
					System.out.println("Employee with Id "+employee.getId()+" and Name "+employee.getName()+" with Experience "+employee.getExp()+" got 30% hike.");
				}
				else if(employee.getExp()>=10)
				{
					System.out.println("Employee with Id "+employee.getId()+" and Name "+employee.getName()+" with Experience "+employee.getExp()+" got 25% hike.");
				}
				else if(employee.getExp()>=5)
				{
					System.out.println("Employee with Id "+employee.getId()+" and Name "+employee.getName()+" with Experience "+employee.getExp()+" got 20% hike.");
				}
				else
				{
					System.out.println("Employee with Id "+employee.getId()+" and Name "+employee.getName()+" with Experience "+employee.getExp()+" got 15% hike.");
				}
			}
		}
		
	}



	public void insertEmployee(Employee employee) {
		
		employeeDao.insertEmployee(employee);
		
	}



	public Employee getEmployeeById(String id) {
		
		return employeeDao.getEmployeeById(id);
		
	}

}
