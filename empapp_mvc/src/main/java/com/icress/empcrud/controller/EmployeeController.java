package com.icress.empcrud.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.icress.empcrud.entity.Employee;
import com.icress.empcrud.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/create_employee_form")
	public String loadCreateEmpForm(Model model) {
		
		model.addAttribute("employee", new Employee());
		
		return "create_employee";
	}
	
	@PostMapping("/create_employee")
	public String createEmployee(@ModelAttribute("employee") Employee employee, 
			Model model) {

		employeeService.createEmployee(employee);
		
		return "redirect:/employees";
	}
	
	@GetMapping("/employees")
	public String getAllEmployees(Model model) {
		
		List<Employee> employeeList = employeeService.getAllEmployees();
		
		model.addAttribute("employees", employeeList);
		
		return "show_employees";
	}
	
	@GetMapping("/update_employee_form")
	public String loadEditEmployeeForm(Model model,
			@RequestParam Long id) {
		
		Employee employee = employeeService.getEmployeeById(id);
		
		model.addAttribute("employee", employee);
		
		return "update_employee_form";
	}
	
	@PostMapping("/update_employee")
	public String updateEmployee(
			@ModelAttribute("employee") Employee employee) {
		
		employeeService.updateEmployeeById(employee);
		
		return "redirect:/employees"; 
	}
	
	@GetMapping("/delete_employee")
	public String deleteEmployee(@RequestParam Long id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/employees";
	}
}