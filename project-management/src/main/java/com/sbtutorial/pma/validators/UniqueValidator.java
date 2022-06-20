package com.sbtutorial.pma.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.sbtutorial.pma.dao.EmployeeRepository;
import com.sbtutorial.pma.entities.Employee;

public class UniqueValidator implements ConstraintValidator<UniqueValue, String>{
	@Autowired
	private EmployeeRepository empRepository;
	
	 @Override
	  public void initialize(UniqueValue constraintAnnotation) {
		 
	  }
	
	/**
	 * spring.jpa.properties.javax.persistence.validation.mode = none;
	 * This property must be set to only runs the validation once
	 */
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		System.out.println(context);
		System.out.println("Entered validation method..");
//		Employee employee = empRepository.findByEmail(value);
//		if (employee != null) {
//			return false;
//		}else {
//			return true;
//		}
		return true;
	}

}
