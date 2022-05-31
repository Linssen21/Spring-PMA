package com.sbtutorial.pma.logging;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * An Aspect is a code that you wanted to run
 * @author Linssen
 *
 */

@Aspect
@Component
public class ApplicationLoggerAspect {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * Is the location where you want a cross cutting concern code want
	 * Pointcut means where should the code to runs
	 * Runs the code to all the controllers
	 * This is the where
	 */
	@Pointcut("within(com.sbtutorial.pma.controllers..*)")
	public void definePackagePointcuts() {
//		empty method just to name the location specified in the pointcut
	}
	
	/**
	 * Runs after the definePackagePointcuts runs
	 * This is the what
	 * Or @After/@Before in AOP it is called the Advice
	 * Join Point
 	 * Point is during your execution is taking place
 	 * Runs when file is accessed on the controllers package
	 * @throws Throwable 
	 * 
	 * @Around executed Before and After
	 */
	@Around("definePackagePointcuts()")
	public Object logAround(ProceedingJoinPoint jp) throws Throwable {
		log.debug("\n \n \n");
		log.debug("******* Before Method Execution ******* \n {}.{} () with arguments[s] = {}", jp.getSignature().getDeclaringTypeName(), jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
		
		log.debug("______________________________ \n \n \n");
		
		Object obj = jp.proceed();
		
	log.debug("******* Before Method Execution ******* \n {}.{} () with arguments[s] = {}", jp.getSignature().getDeclaringTypeName(), jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
		
		log.debug("______________________________ \n \n \n");
		
		return obj;
		
	}
}
