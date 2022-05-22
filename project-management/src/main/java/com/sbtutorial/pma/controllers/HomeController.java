package com.sbtutorial.pma.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sbtutorial.pma.dao.EmployeeRepository;
import com.sbtutorial.pma.dao.ProjectRepository;
import com.sbtutorial.pma.dto.ChartData;
import com.sbtutorial.pma.dto.EmployeeProject;
import com.sbtutorial.pma.entities.Employee;
import com.sbtutorial.pma.entities.Project;

@Controller
public class HomeController {
	
	/**
	 * Inject the Project Repository to this controller
	 */
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {
		Map<String, Object> map = new HashMap<>();
		
		 // Overrides the findAll to return a list of Project
		List<Project> projects = proRepo.findAll();
		 //Pass the data projectsList
		model.addAttribute("projectsList", projects);
		
		// Get Project Status
		List<ChartData> projectData = proRepo.getProjectStatus();
		// Convert projectData Object into a JSON structure for Chart JS
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);
		// Output : [ ["NOTSTARTED", 1], ["INPROGRESS", 2], ["COMPLETED", 1] ]
		model.addAttribute("projectStatusCount", jsonString);
		 
		 // Overrides the findAll to return a list of Project
//		List<Employee> employees = employeeRepo.findAll();
//		model.addAttribute("employeesList", employees);
		
		// Execute the Custom Query from the (DAO) Data Access Object
		List<EmployeeProject> employeesProjectCount = employeeRepo.employeeProject();
		model.addAttribute("employeesProjectCount", employeesProjectCount);
		
		
		// Render the home.html
		return "main/home";
	}
}
