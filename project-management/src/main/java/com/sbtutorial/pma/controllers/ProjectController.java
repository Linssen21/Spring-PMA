package com.sbtutorial.pma.controllers;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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
import com.sbtutorial.pma.dao.ProjectRepository;
import com.sbtutorial.pma.entities.Employee;
import com.sbtutorial.pma.entities.Project;
import com.sbtutorial.pma.services.EmployeeService;
import com.sbtutorial.pma.services.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	/**
	 * Inject an instance of the Project Repository
	 */
	@Autowired
	ProjectService projectService;
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping
	public String displayProjects(Model model) {
		 // Overrides the findAll to return a list of Project
		Iterable<Project> projects = projectService.getAll();
		model.addAttribute("projectsList", projects);
		
		return "projects/list-projects";
	}
		
	
	
	@RequestMapping("/new")
	public String displayProjectForm(Model model) {
		
		// Bind the form with the Project Model
		Project aProject = new Project();
		// Get List of employees
		this.fetchEmployee(model);
		// Add New Project Instance
		model.addAttribute("project", aProject);
		// Generate the view with new-project.html
		return "projects/new-project";
	}
	
	protected void fetchEmployee(Model model) {
		Iterable<Employee> employees = employeeService.getAll();
		model.addAttribute("allEmployees", employees);
	}
	
	// Update List<Long> employee to Optional<Long> selectedEmployees to make Request parameteres as optional
	@PostMapping("/save")
	public String createProject(@RequestParam Optional<Long> selectedEmployees ,Model model, @Valid Project project, Errors errors) {
		// this should handle saving to the database
//		// Automatically save the project with the List of Employees
//		projectService.save(project);
		// Find all by id based on the employee
//		Iterable<Employee> chosenEmployee = employeeRepo.findAllById(employees);
//		// Loop over the chosenEmployee and set the Project on the Employee table / Update the employee to set its Project Id field
//		for(Employee emp : chosenEmployee) {
//			emp.setProject(project);
//			employeeRepo.save(emp);
//		}
		
		// Error handling
		if(errors.hasErrors()) {
			this.fetchEmployee(model);
			return "projects/new-project";
		}
		
		// Automatically save the project with the List of Employees
		projectService.save(project);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/projects";
	}
	
	
}
