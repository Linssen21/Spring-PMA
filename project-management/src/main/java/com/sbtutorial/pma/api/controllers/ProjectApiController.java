package com.sbtutorial.pma.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sbtutorial.pma.dao.ProjectRepository;
import com.sbtutorial.pma.entities.Project;

@RestController
@RequestMapping("/app-api/projects")
public class ProjectApiController {
	
	@Autowired
	ProjectRepository projectRepository;
	
	@GetMapping
	public Iterable<Project> getProjects(){
		return projectRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Project getProjectById(@PathVariable("id") Long id) {
		return projectRepository.findById(id).get();
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Project create(@Valid @RequestBody Project project) {
		return projectRepository.save(project);
	}
	
	
	@PatchMapping(path = "/{id}", consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	private Project partiaUpdate(@Valid @PathVariable("id") Long id, @RequestBody Project patchProject) {
		
		// Find project by id
		Project project = projectRepository.findById(id).get();
		
		// Check the request data and set it on the Project Object
		if(patchProject.getName() != null) {
			project.setName(patchProject.getName());
		}
		if(patchProject.getDescription() != null) {
			project.setDescription(patchProject.getDescription());
		}
		if(patchProject.getStage() != null) {
			project.setStage(patchProject.getStage());
		}
		
		return projectRepository.save(project);
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	private void delete(@PathVariable("id") Long id) {
		try {
			projectRepository.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	
	
}
