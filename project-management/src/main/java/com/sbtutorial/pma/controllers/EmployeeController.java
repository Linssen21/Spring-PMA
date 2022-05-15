package com.sbtutorial.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sbtutorial.pma.dao.EmployeeRepository;
import com.sbtutorial.pma.entities.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	/**
	 * Inject an instance of the Employee Repository
	 */
	@Autowired
	EmployeeRepository employeeRepo;
	
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
		employeeRepo.save(employee);
		
		// Redirect after submission
		return "redirect:/employees/new";
		
	}
}
