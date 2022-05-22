package com.sbtutorial.pma;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sbtutorial.pma.dao.EmployeeRepository;
import com.sbtutorial.pma.dao.ProjectRepository;
import com.sbtutorial.pma.entities.Employee;
import com.sbtutorial.pma.entities.Project;

@SpringBootApplication
public class ProjectManagementApplication {
	
	/**
	 * Inject an instance of the Employee Repository
	 */
	@Autowired
	EmployeeRepository employeeRepo;
	
	/**
	 * Inject an instance of the Project Repository
	 */
	@Autowired
	ProjectRepository projectRepo;
	
	/**
	 * Spring Entry point
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}
	
	/**
	 * Only Run Once set as a bean using the Bean Annotations
	 * @return
	 */
//	@Bean
//	CommandLineRunner runner() {
//		return args -> {
//			Employee emp1 = new Employee("Linssen", "Diocares", "linssen001@gmail.com");
//			Employee emp2 = new Employee("Daniel", "Diocares", "daniel@gmail.com");
//			Employee emp3 = new Employee("Vhyn", "Diocares", "vhyn@gmail.com");
//			Employee emp4 = new Employee("Rinsen", "Diocares", "rinsen@gmail.com");
//			Employee emp5 = new Employee("Oreki", "Diocares", "oreki@gmail.com");
//			Employee emp6 = new Employee("Koutaro", "Diocares", "koutaro@gmail.com");
//			
//			Project pro1 = new Project("Production Deploy", "NOTSTARTED", "Description Test 1");
//			Project pro2 = new Project("New Employee Budget", "COMPLETE", "Description Test 2");
//			Project pro3 = new Project("Office Reconstruction", "INPROGRESS", "Description Test 3");
//			Project pro4 = new Project("Improve Internet Connection", "INPROGRESS", "Description Test 4");
//			
//			// Assign Employee to Projects
//			// Need to to do this manually
//			pro1.addEmployee(emp1);
//			pro1.addEmployee(emp2);
//			pro2.addEmployee(emp3);
//			pro3.addEmployee(emp1);
//			pro4.addEmployee(emp1);
//			pro4.addEmployee(emp3);
//			
//			// Need to set both sides of the relationship manually
//			emp1.setProjects(Arrays.asList(pro1, pro3, pro4));
//			emp2.setProjects(Arrays.asList(pro1));
//			emp3.setProjects(Arrays.asList(pro2, pro4));
//			
//			// Save employees in database
//			employeeRepo.save(emp1);
//			employeeRepo.save(emp2);
//			employeeRepo.save(emp3);
//			employeeRepo.save(emp4);
//			employeeRepo.save(emp5);
//			employeeRepo.save(emp6);
//			
//			// Save Projects in database
//			projectRepo.save(pro1);
//			projectRepo.save(pro2);
//			projectRepo.save(pro3);
//			projectRepo.save(pro4);
//
//		};
//	}

}
