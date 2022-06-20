package com.sbtutorial.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sbtutorial.pma.dto.ChartData;
import com.sbtutorial.pma.entities.Project;

/**
 * 
 * @author Linssen
 *	Using the CrudRepository, we can Insert, Update, Delete on the Database
 * @RepositoryRestResource - This annotation automatically generate rest routes for the repository
 */
@RepositoryRestResource(collectionResourceRel = "api-projects", path = "api-projects")
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {
	
	/**
	 * Override the default Crud Repository findAll() which returns an Iterable
	 */
//	@Override
//	public List<Project> findAll();
	
	@Query(nativeQuery = true, value = "SELECT  stage as label, COUNT(*) as value FROM PROJECT GROUP BY stage;")
	public List<ChartData> getProjectStatus();
	
	
}
