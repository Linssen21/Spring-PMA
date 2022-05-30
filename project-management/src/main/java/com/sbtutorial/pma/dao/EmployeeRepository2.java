package com.sbtutorial.pma.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.sbtutorial.pma.dto.EmployeeProject;
import com.sbtutorial.pma.entities.Employee;

//@Profile Not Really recommended to use but just for a test
@Repository
@Profile("test")
public class EmployeeRepository2 implements EmployeeRepository {
	
	@Override
	public List<Employee> findAll() {
		Employee employee1 = new Employee("Dummy1", "Dumms", "dummy1@gmail.com");
		Employee employee2 = new Employee("Dummy2", "Dumms", "dummy2@gmail.com");
		Employee employee3 = new Employee("Dummy3", "Dumms", "dummy3@gmail.com");
		
		return Arrays.asList(employee1, employee2, employee3);
	}
	
	@Override
	public <S extends Employee> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Employee> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Employee> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Employee> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Employee entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Employee> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public List<Employee> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<EmployeeProject> employeeProject() {
		// TODO Auto-generated method stub
		return null;
	}

}
