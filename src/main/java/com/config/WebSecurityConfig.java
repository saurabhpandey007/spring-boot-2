package com.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.security.CustomUserDetailsService;

@Configuration
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

 private Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);
	
 @Autowired 
 private UserDetailsService userDetailsService;
 
 @Autowired
 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {  
	 logger.info("Configure Authentication.");
	 auth.userDetailsService(userDetailsService);
 } 
 
 @Override
 protected void configure(HttpSecurity http) throws Exception {
	logger.info("configuring security.");
   http
   		.authorizeRequests()
   				.antMatchers("/amway-1.4.0.RELEASE/css/**").permitAll()
   				.antMatchers("/amway-1.4.0.RELEASE/js/**").permitAll()
   				.antMatchers(HttpMethod.GET,"/show").access("hasRole('ROLE_ADMIN')")
   				.anyRequest().access("hasRole('ROLE_USER')")
		   		.anyRequest().authenticated()
		   	.and()
		.formLogin()
				.loginPage("/login").successForwardUrl("/home").permitAll()
				.usernameParameter("username").passwordParameter("password")
			.and()
		.logout()
				.logoutSuccessUrl("/login?logout").permitAll() 
			.and()
		.exceptionHandling()
				.accessDeniedPage("/403")
			.and()
		.csrf().disable();
 }
 
}