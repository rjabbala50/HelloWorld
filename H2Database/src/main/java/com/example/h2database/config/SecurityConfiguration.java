package com.example.h2database.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity (securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	/*
	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
			auth
				.inMemoryAuthentication()
				.withUser("user1")
				.password("password")
				.
				.roles("ADMIN") ;
	}
	
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/themes/**").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.and()
			.logout();
	}
}
