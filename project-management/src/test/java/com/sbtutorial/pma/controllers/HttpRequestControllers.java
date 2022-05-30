package com.sbtutorial.pma.controllers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * 
 * @author Linssen
 * WebEnvironment.RANDOM_PORT - Start TomCat at random port
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@TestPropertySource("classpath:application_test.properties")
public class HttpRequestControllers {
	@LocalServerPort
	private int port;
	
	// reads the html
	@Autowired
	private TestRestTemplate restTemplate;
	
	/**
	 * Run a test on Home View
	 * Works like a controller but for testing
	 */
	@Test
	public void homePageReturnsVersionNumberCorrectly_thenSuccess() {
		String renderedHtml = this.restTemplate.getForObject("http://localhost:" + port + "/", String.class);
		assertEquals(renderedHtml.contains("3.3.3"), true);
	}
	
}
