package com.sbtutorial.pma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sbtutorial.pma.dao.EmployeeRepository;

@Service
public class EmployeeService {
	
	/**
	 * Field Injection
	 */
	@Qualifier("staffRepositoryImpl2")
	@Autowired
	IStaffRepository employeeRepo;

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
