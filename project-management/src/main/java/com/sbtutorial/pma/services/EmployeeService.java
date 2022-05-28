package com.sbtutorial.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sbtutorial.pma.dao.EmployeeRepository;
import com.sbtutorial.pma.dto.EmployeeProject;
import com.sbtutorial.pma.entities.Employee;

/**
 * Create a Service Layer and Inject the Repository to the Service
 * @author Linssen
 *
 */
@Service
public class EmployeeService {
	
	/**
	 * Field Injection for the Employee Repository
	 */
	@Autowired
	EmployeeRepository employeeRepository;
	
	/**
	 * 
	 * @param employee
	 * @return
	 */
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	/**
	 * Fetch all data from the employee table
	 * @return {@link List} of {@link Employee}
	 */
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}
	
	/**
	 * Fetch data from the project employee table
	 * @return {@link List} of {@link EmployeeProject}
	 */
	public List<EmployeeProject> employeeProjects() {
		return employeeRepository.employeeProject();
	}
	
	
	
	/**
	 * Field Injection
	 */
//	@Qualifier("staffRepositoryImpl2") - Sample Interface Implementation
//	@Autowired
//	IStaffRepository employeeRepo; - Interface

	/**
	 * Constructor Injection
	 * @param employeeRepo
	 * @Qualifier Annotation Select the Bean to be implemented, must be in camel case
	 */
//	public EmployeeService(@Qualifier("staffRepositoryImpl2") IStaffRepository employeeRepo) {
//	super();
//		this.employeeRepo = employeeRepo;
//	}
	

	/**
	 * Setter Injection
	 * @param employeeRepo
	 */
//	@Autowired
//	@Qualifier("staffRepositoryImpl2")
//	public void setEmployeeRepo(EmployeeRepository employeeRepo) {
//		this.employeeRepo = employeeRepo;
//	}

}
