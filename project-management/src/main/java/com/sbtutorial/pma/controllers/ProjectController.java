package com.sbtutorial.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sbtutorial.pma.dao.ProjectRepository;
import com.sbtutorial.pma.entities.Employee;
import com.sbtutorial.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	/**
	 * Inject an instance of the Project Repository
	 */
	@Autowired
	ProjectRepository proRepo;
	
	@GetMapping
	public String displayProjects(Model model) {
		 // Overrides the findAll to return a list of Project
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projectsList", projects);
		
		return "projects/list-projects";
	}
		
	
	
	@RequestMapping("/new")
	public String displayProjectForm(Model model) {
		
		// Bind the form with the Project Model
		Project aProject = new Project();
		model.addAttribute("project", aProject);
		
		// Generate the view with new-project.html
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		// this should handle saving to the database
		proRepo.save(project);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/projects";
	}
	
	
}
