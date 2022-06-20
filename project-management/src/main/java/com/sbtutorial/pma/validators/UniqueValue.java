package com.sbtutorial.pma.validators;

import java.lang.annotation.Documented;
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
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UniqueValidator.class)
public @interface UniqueValue {
	 //error message
	String message() default "Unique Constraint violated";
	 //represents group of constraints
	Class<?>[] groups() default{};
	 //represents additional information about annotation
	Class<? extends Payload>[] payload() default{};

}
