package com.sbtutorial.pma.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Automatically added on the spring context by using the Configuration Annotation
 * DataSource will be automatically connected to the Database define on the application.properties
 * @author Linssen
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	BCryptPasswordEncoder bCryptEncoder;
	
	/**
	 * Override the configure method from the parent/base class
	 * withDefaultSchema() Create default schema or table on the database
	 *
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username, password, enabled " + "from user_accounts where username = ?")
		.authoritiesByUsernameQuery("select username, role " + "from user_accounts where username = ?")
		.dataSource(dataSource)
		.passwordEncoder(bCryptEncoder);
//		auth.inMemoryAuthentication()
//		.withUser("myuser")
//			.password("pass")
//			.roles("USER")
//		.and()
//		.withUser("linssen")
//			.password("pass2")
//			.roles("USER")
//		.and()
//		.withUser("managerUser")
//			.password("pass3")
//			.roles("ADMIN");
	}
	
	/**
	 * Authentication Requires a PasswordEncoder Bean
	 *  NoOpPasswordEncoder.getInstance(); - Not a good idea for production should be encrypted
	 * @return
	 */
//	@Bean
//	public PasswordEncoder getPasswordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
	
	/**
	 * Authorization Define Roles
	 * Configure Routes to only be accessed by a user with a role of Admin
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		/**
		 * Only Admin can access the projects/new
		 * Other routes can be accessed if authenticated
		 * antMatchers set priority
		 * hasRole - should have a field name role and a value of ROLE_ADMIN
	 * hasAuthority - only expect if the field has an ADMIN value
		 */
		http.authorizeRequests()
		
		.antMatchers("/employees/new").hasRole("ADMIN")
		.antMatchers("/employees/save").hasRole("ADMIN")
		.antMatchers("/projects/save").hasAuthority("ADMIN")
		.antMatchers("/projects/new").hasAuthority("ADMIN")
		.antMatchers("/", "/**").permitAll()
		.and().formLogin();
//		.antMatchers("/h2_console/**").permitAll()
//		.and().formLogin();
		
		
//		http.csrf().disable();
//		http.headers().frameOptions().disable();
	}

}
