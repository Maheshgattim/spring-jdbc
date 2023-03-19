package com.spring.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.springjdbc.bussiness.EmployeeBussiness;
import com.spring.springjdbc.bussiness.EmployeeBussinessImpl;
import com.spring.springjdbc.dto.Employee;

public class App 
{
    public static void main( String[] args )
    {

    	
		ApplicationContext context = new ClassPathXmlApplicationContext("configmetadata.xml");
    	
    	EmployeeBussiness employeeBussiness =(EmployeeBussinessImpl)context.getBean("employeeBussinessImpl");
    	
    	//Employee emp = new Employee("13","kasi",19);
    	
    	//employeeBussiness.insertEmployee(emp);
    	
    	//employeeBussiness.printAllEmploeeHikes();
    	
    	Employee employee = null;
		try {
			employee = employeeBussiness.getEmployeeById("25");
		} catch (Exception e) {
		
		}
    	if(employee!=null)
    	System.out.println(employee.toString());
    	else
    		System.out.println("Id didnt matched with the data in database");
    }
}
