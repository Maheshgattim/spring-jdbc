package com.spring.springjdbc.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.spring.springjdbc.dto.Employee;
@Component
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	public List<Employee> findAllEmployees() {
		
		EmployeeRowMapper rowMapper = new EmployeeRowMapper();
		
		String sql = "select * from employee";

		List<Employee> employees =jdbcTemplate.query(sql, rowMapper);
		
		return employees;
	}
	
	public void insertEmployee(Employee employee) {
		/*String sql = "insert into employee values('"+employee.getId()+
				"','"+employee.getName()+"',"+employee.getExp()+")";*/
		
		String sql = "insert into employee values(?,?,?)";
		System.out.println(sql);
		
		jdbcTemplate.update(sql,employee.getId(),employee.getName(),employee.getExp());
	}
	
	public Employee getEmployeeById(String id) 
	{
		EmployeeRowMapper rowMapper = new EmployeeRowMapper();
		
		Employee employee = jdbcTemplate.queryForObject("Select * from employee where id=?",rowMapper,id);
		
		return employee;
	}
}
