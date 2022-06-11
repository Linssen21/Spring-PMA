package com.sbtutorial.pma.controllers;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		Iterable<Employee> employees = employeeService.getAll();
		model.addAttribute("project", aProject);
		model.addAttribute("allEmployees", employees);
		// Generate the view with new-project.html
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project, @RequestParam List<Long> employees ,Model model) {
		// this should handle saving to the database
		// Automatically save the project with the List of Employees
		projectService.save(project);
		// Find all by id based on the employee
//		Iterable<Employee> chosenEmployee = employeeRepo.findAllById(employees);
//		// Loop over the chosenEmployee and set the Project on the Employee table / Update the employee to set its Project Id field
//		for(Employee emp : chosenEmployee) {
//			emp.setProject(project);
//			employeeRepo.save(emp);
//		}
		
	
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/projects";
	}
	
	
}
