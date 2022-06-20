package com.sbtutorial.pma.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sbtutorial.pma.validators.UniqueValue;


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
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
// Change Generated Value to Sequence for performance because of batch sequence or batch processing
	@Id
	@SequenceGenerator(name="employee_seq", sequenceName="employee_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "employee_seq")
	private long employeeId;
	
	@NotBlank(message="Must Give a first name")
	@Size(min = 2, max = 50)
	private String firstName;
	
	@NotBlank(message="Must Give a last name")
	@Size(min = 1, max = 50)
	private String lastName;
	
	@NotBlank
	@Email(message="Must be a valid email")
	@Column(unique = true)
	@UniqueValue
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
	@JsonIgnore
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
