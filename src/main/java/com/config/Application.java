package com.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EntityScan(basePackages="com.model")
@EnableJpaRepositories(basePackages = "com.repository")
public class Application extends SpringBootServletInitializer{

	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(Application.class);
	    }
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
