package com.sbtutorial.pma.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 
 * @author Linssen
 * Mark the class with @Entity annotation so the spring boot will know that this is an entity
 * and will automatically create a database for us
 */
@Entity
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
	
	 
	/**
	 *  @OneToMany annotation Generates a table for the Project and Employee
	 *  (mappedBy = "project) this arguments will let us need to define a property on the Employee, this also remove the generated database
	 *  
	 */
	@OneToMany(mappedBy = "project")
	private List<Employee> employees;
	
	// Constructors
	public Project() {
		
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
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
