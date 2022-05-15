package com.sbtutorial.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sbtutorial.pma.dao.ProjectRepository;
import com.sbtutorial.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	/**
	 * Inject an instance of the Project Repository
	 */
	@Autowired
	ProjectRepository proRepo;
	
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
		return "redirect:/projects/new";
	}
}
