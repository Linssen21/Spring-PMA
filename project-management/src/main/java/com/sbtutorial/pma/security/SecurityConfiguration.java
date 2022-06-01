package com.sbtutorial.pma.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Automatically added on the spring context by using the Configuration Annotation
 * @author Linssen
 *
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	/**
	 * Override the configure method from the parent/base class
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("myuser")
			.password("pass")
			.roles("USER")
		.and()
		.withUser("linssen")
			.password("pass2")
			.roles("USER");
	}
	
	/**
	 * Authentication Requires a PasswordEncoder Bean
	 * @return
	 */
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
