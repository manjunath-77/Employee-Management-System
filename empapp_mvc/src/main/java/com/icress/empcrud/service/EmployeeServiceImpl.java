package com.icress.empcrud.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.icress.empcrud.entity.Employee;
import com.icress.empcrud.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void createEmployee(Employee employee) {

		int age = calculateAge(employee);
		employee.setAge(age);

		employeeRepository.save(employee);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		
		List<Employee> employeeList = employeeRepository.findAll();
		
		return employeeList;
	}
	
	@Override
	public Employee getEmployeeById(Long empId) {
		Employee employee = employeeRepository.findById(empId).get();
		
		return employee;
	}

	@Override
	public void updateEmployeeById(Employee employee) {
		
		int age = calculateAge(employee);
		employee.setAge(age);
		
		employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(Long empId) {
		employeeRepository.deleteById(empId);
	}
	
	private int calculateAge(Employee employee) {
		
		LocalDate birthDate = employee.getDob().toInstant()
				.atZone(ZoneId.systemDefault()).toLocalDate();
		
		LocalDate currentDate = new Date().toInstant()
				.atZone(ZoneId.systemDefault()).toLocalDate();
		
		return Period.between(birthDate, currentDate).getYears();
	}
}