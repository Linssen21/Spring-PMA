package com.sbtutorial.pma.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sbtutorial.pma.dao.EmployeeRepository;
import com.sbtutorial.pma.entities.Employee;

@RestController
@RequestMapping("/app-api/employees")
public class EmployeeApiController {

	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping
	public Iterable<Employee> getEmployees(){
		return empRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("id") Long id) {
		return empRepo.findById(id).get();
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee create(@Valid @RequestBody Employee employee) {
		return empRepo.save(employee);
	}
	
	/**
	 * Put Request update the Employee Table and then delete the field from a bridge table (project_employee) because of cascading value
	 * @param employee
	 * @return
	 */
	@PutMapping(path = "/{id}", consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	private Employee update(@Valid @RequestBody Employee employee) {
		return empRepo.save(employee);
	}
	
	/**
	 * 
	 * @param id
	 * @param patchEmployee
	 * @return {@link Employee}
	 * Use Patch for Soft Update, the cascade effect will not be triggered the same with the update method
	 */
	
	@PatchMapping(path = "/{id}", consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	private Employee partialUpdate(@Valid @PathVariable("id") Long id, @RequestBody Employee patchEmployee) {
		
		// Find employee by ID
		Employee employee = empRepo.findById(id).get();
		
		// Check the request data and set it on the Employee Object
		if(patchEmployee.getEmail() != null) {
			employee.setEmail(patchEmployee.getEmail());
		}
		
		if(patchEmployee.getFirstName() != null) {
			employee.setFirstName(patchEmployee.getFirstName());
		}
		
		if(patchEmployee.getLastName() != null) {
			employee.setLastName(patchEmployee.getLastName());
		}
		
		return empRepo.save(employee);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	private void delete(@PathVariable("id") Long id) {
		try {
			empRepo.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
	
}
