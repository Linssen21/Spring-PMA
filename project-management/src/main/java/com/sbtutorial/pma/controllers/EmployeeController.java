package com.sbtutorial.pma.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		Iterable<Employee> employees = empService.getAll();
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
	public String createEmployee(Model model, @Valid Employee employee, Errors errors) {
		// If Employee has Errors redirect to the New Employee Form
		if(errors.hasErrors()) {
			return "employees/new-employee";
		}
		// save to the database
		empService.save(employee);
		
		// Redirect after submission
		return "redirect:/employees";
		
	}
	
	@GetMapping("/update")
	public String displayEmployeeUpdateForm(@RequestParam("id") Long id, Model model) {
		Employee employee = empService.findByEmployeeId(id);
		
		model.addAttribute("employee",  employee);
		
		return "employees/new-employee";
	}
	
	@GetMapping("delete")
	public String deleteEmployee(@RequestParam("id") Long id) {
		Employee employee = empService.findByEmployeeId(id);
		
		empService.delete(employee);
		
		return "redirect:/employees";
	}
	

	
	
}
