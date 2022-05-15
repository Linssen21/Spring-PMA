package com.sbtutorial.pma.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sbtutorial.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@RequestMapping("/new")
	public String displayProjectForm(Model model) {
		
		// Bind the form with the Project Model
		Project aProject = new Project();
		model.addAttribute("project", aProject);
		
		// Generate the view with new-project.html
		return "new-project";
	}
	
	@PostMapping("/save")
	public String saveProject(Project project, Model model) {
		// this should handle saving to the database
	}
}
