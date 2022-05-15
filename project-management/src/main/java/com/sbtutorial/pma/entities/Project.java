package com.sbtutorial.pma.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Project {
	
// Set the attributes
/**
 * @GeneratedValue(strategy=GenerationType.AUTO)
 * Parts of the Hibernate 
 * This annotations used to automatically map to a database table
 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long projectId;
	private String name;
	
	private String stage; // NOTSTARTED, COMPLETE, INPROGRESS
	
	private String description;
	
	// Constructors
	public Project() {
		
	}
	
	public Project( String name, String stage, String description) {
		super();
		this.name = name;
		this.stage = stage;
		this.description = description;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	

}
