package com.sbtutorial.pma.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author Linssen
 * RetentionPolicy.RUNTIME, means the annotation will be 
 * use on run-time
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueValidator.class)
public @interface UniqueValue {
	String message() default "Unique Constraint violated";
	
	Class<?>[] groups() default{};
	
	Class<? extends Payload>[] payload() default{};

}
