package com.sbtutorial.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbtutorial.pma.dao.ProjectRepository;
import com.sbtutorial.pma.dto.ChartData;
import com.sbtutorial.pma.entities.Project;

/**
 * Create a Service Layer and Inject the Repository to the Service
 * @author Linssen
 *
 */
@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository projectRepository;
	
	
	public List<Project> getAll() {
		return projectRepository.findAll();
	}
	
	public Project save(Project project) {
		return projectRepository.save(project);
	}
	
	public List<ChartData> getProjectStatus() {
		return projectRepository.getProjectStatus();
	}

}
