package com.sbtutorial.pma.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
public class AppErrorController implements ErrorController{
	
	@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {
		/**
		 * Get the request status code and store it to the status variable
		 * getAttribute - returns a type of object
		 */
		 Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		 
		 if(status != null) {
			 Integer statusCode = Integer.valueOf(status.toString());
			 
			 if(statusCode == HttpStatus.NOT_FOUND.value()) {
				 return "errorpages/error-404";
			 }else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				 return "errorpages/error-500";
			 }else if(statusCode == HttpStatus.FORBIDDEN.value()) {
				 return "errorpages/error-403";
			 }
		 }
		 
		 return "errorpages/error";
	}
}
