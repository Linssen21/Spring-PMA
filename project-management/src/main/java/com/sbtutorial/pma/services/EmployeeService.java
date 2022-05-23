package com.sbtutorial.pma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbtutorial.pma.dao.EmployeeRepository;

@Service
public class EmployeeService {
	
	/**
	 * Field Injection
	 */
	@Autowired
	EmployeeRepository employeeRepo;

	/**
	 * Constructor Injection
	 * @param employeeRepo
	 */
//	public EmployeeService(EmployeeRepository employeeRepo) {
//		super();
//		this.employeeRepo = employeeRepo;
//	}
	

	/**
	 * Setter Injection
	 * @param employeeRepo
	 */
//	@Autowired
//	public void setEmployeeRepo(EmployeeRepository employeeRepo) {
//		this.employeeRepo = employeeRepo;
//	}

}
