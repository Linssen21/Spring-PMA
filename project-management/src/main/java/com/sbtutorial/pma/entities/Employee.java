package com.sbtutorial.pma.entities;

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
import javax.persistence.ManyToOne;


/**
 * 
 * @author Linssen
 * @Entity annotation automatically creates the table on the database
 * @Id annotation set the employeeId as an ID
 * @GeneratedValue set the employeeId as Auto Increment or auto generated
 */
@Entity
public class Employee {
	
//	Fields
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long employeeId;
	
	private String firstName;
	private String lastName;
	private String email;
	
	/**
	 * Creates a foreign key on the database
	 * Set Operations when the Project is updated/add/remove
	 * 
	 * set fetch type lazy to fasten up the application, only loads the project and
	 * Access the employee in another way
	 * 
	 * Many Employee can work on one Project
	 * 
	 * CascadeType.PERSIST persisted then all its associated child entities will also be persisted.
	 */
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST }, fetch = FetchType.LAZY)
	@JoinTable(
		name = "project_employee", 
		joinColumns = @JoinColumn(name = "employee_id"), 
		inverseJoinColumns = @JoinColumn(name = "project_id")
	)
	private List<Project> projects;
	
	
	public Employee() {
		
	}
	
	public List<Project> getProjects() {
		return projects;
	}


	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}


	// Do not instantiate the id, the database will handle the Id
	public Employee(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	public long getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
	

}
