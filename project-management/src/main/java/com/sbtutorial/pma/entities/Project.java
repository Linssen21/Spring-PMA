package com.sbtutorial.pma.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@SequenceGenerator(name="project_seq", sequenceName="project_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "project_seq")
	private long projectId;
	private String name;
	
	private String stage; 
	
	private String description;
	
	 
	/**
	 *  @OneToMany annotation Generates a table for the Project and Employee
	 *  (mappedBy = "project) this arguments will let us need to define a property on the Employee, this also remove the generated database
	 *  
	 */
//	@OneToMany(mappedBy = "project")
	
	/**
	 * @ManyToMany Annotation set the Relationship 
	 * of Projects to have Many (Employee)
	 * Set the Cascade to the Employee table because it is set with Many
	 * Tell Hibernate that we will have a many to many Relationship with Project
	 */
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST }, fetch = FetchType.LAZY)
	@JoinTable(
		name = "project_employee", 
		joinColumns = @JoinColumn(name = "project_id"), 
		inverseJoinColumns = @JoinColumn(name = "employee_id")
	)
	private List<Employee> employees;
	
	// Constructors
	public Project() {
		
	}
	/**
	 * Use @JsonIgnore Annotation to avoid error fetching data 
	 * using REST
	 * Ignores this field for serialization, causes infinite loop
	 */
	@JsonIgnore
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
	
	
	public void addEmployee(Employee emp) {
		// If employees is null create a new Array list
		if(employees == null) {
			employees = new ArrayList<>();
		}
		// Add the given employee
		employees.add(emp);
	}
	
	

}
