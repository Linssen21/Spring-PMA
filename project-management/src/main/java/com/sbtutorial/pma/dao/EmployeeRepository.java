package com.sbtutorial.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sbtutorial.pma.dto.EmployeeProject;
import com.sbtutorial.pma.entities.Employee;

/**
 * 
 * @author Linssen
 *	Using the CrudRepository, we can Insert, Update, Delete on the Database
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	/**
	 * Override the default Crud Repository findAll() which returns an Iterable
	 */
	@Override
	public List<Employee> findAll();
	
	/**
	 * Custom Query
	 * nativeQuery = true, will use SQL to create the Query
	 * Create an Interface for the custom Query
	 */
	@Query(nativeQuery = true, value = "SELECT emp.first_name AS firstName, emp.last_name AS lastName, COUNT(proemp.employee_id) AS projectCount FROM EMPLOYEE emp left join project_employee proemp ON proemp.employee_id = emp.employee_id GROUP BY emp.first_name, emp.last_name ORDER BY 3 DESC;")
	public List<EmployeeProject> employeeProject();

}
