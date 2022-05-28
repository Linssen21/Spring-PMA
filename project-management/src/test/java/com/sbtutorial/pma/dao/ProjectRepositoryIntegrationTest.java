package com.sbtutorial.pma.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sbtutorial.pma.ProjectManagementApplication;
import com.sbtutorial.pma.dao.ProjectRepository;
import com.sbtutorial.pma.entities.Project;

/**
 * @description This is a Test Script that auto loads the schema and data SQL,
 * and loads the application_test.properties instead
 * Loads the Main Method of the PMA Code
 * @author Linssen
 * ExecutionPhase.BEFORE_TEST_METHOD Run the script/code before the test
 * @SqlGroup- Run SQL files
 * 
 * @SpringBootTest - Make sure the package name on the src/test/java is the same with src/main/java
 */
//@ContextConfiguration(classes = ProjectManagementApplication.class)
//@DataJpaTest
@SpringBootTest
@ExtendWith(SpringExtension.class)
@SqlGroup({
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:schema.sql", "classpath:data.sql"}), 
	@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:drop.sql")
})
@TestPropertySource("classpath:application_test.properties")
public class ProjectRepositoryIntegrationTest {
	@Autowired
	ProjectRepository proRepo;
	
	@Test
	public void ifNewProjectSaved_thenSuccess() {
		Project newProject = new Project("New Test Project", "COMPLETE", "Test Description");
		proRepo.save(newProject);
		Iterable<Project> projTest = proRepo.findAll();
		projTest.forEach((proj) -> System.out.println(proj.getName()));
		assertEquals(13, proRepo.findAll().size());
		
	}
	
}
