package com.sbtutorial.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sbtutorial.pma.dto.ChartData;
import com.sbtutorial.pma.entities.Project;

/**
 * 
 * @author Linssen
 *	Using the CrudRepository, we can Insert, Update, Delete on the Database
 */
public interface ProjectRepository extends CrudRepository<Project, Long> {
	
	/**
	 * Override the default Crud Repository findAll() which returns an Iterable
	 */
	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery = true, value = "SELECT  stage as label, COUNT(*) as value FROM PROJECT GROUP BY stage;")
	public List<ChartData> getProjectStatus();
	
	
}
