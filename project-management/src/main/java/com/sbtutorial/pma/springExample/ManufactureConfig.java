package com.sbtutorial.pma.springExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Automatically Read this as Configuration Class
 * @author Linssen
 *
 */

@Configuration
public class ManufactureConfig {
	/**
	 * Inject the Car Instance globally 
	 * @return
	 */
	@Bean
	public Car newCar() {
		Engine e = new Engine();
		Doors d = new Doors();
		Tires t = new Tires();
		return new Car(e, d, t);
	}

}
