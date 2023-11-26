package com.icress.empcrud.service;

import java.util.List;

import com.icress.empcrud.entity.Employee;

public interface EmployeeService {
	
	public void createEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(Long id);
	
	public void updateEmployeeById(Employee employee);
	
	public void deleteEmployeeById(Long id);
}
