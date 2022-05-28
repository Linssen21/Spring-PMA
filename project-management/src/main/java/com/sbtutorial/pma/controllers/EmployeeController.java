package com.sbtutorial.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sbtutorial.pma.dao.EmployeeRepository;
import com.sbtutorial.pma.entities.Employee;
import com.sbtutorial.pma.services.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	/**
	 * Field Injection
	 * Inject an instance of the Employee Service
	 */
	
	@Autowired
	EmployeeService empService;
	

	@GetMapping
	public String displayEmployees(Model model) {
		 // Overrides the findAll to return a list of Project
		List<Employee> employees = empService.getAll();
		model.addAttribute("employeesList", employees);
		
		return "employees/list-employees";
		
	}
	
	@RequestMapping("/new")
	public String displayEmployeeForm(Model model) {
		
		// Bind the form with the Employee Model
		Employee aEmployee = new Employee();
		model.addAttribute("employee", aEmployee);
		
		// Generate the view with new-employee.html
		return "employees/new-employee";
	}
	
	@PostMapping("/save")
	public String createEmployee(Employee employee, Model model) {
		// save to the database
		empService.save(employee);
		
		// Redirect after submission
		return "redirect:/employees";
		
	}
}
